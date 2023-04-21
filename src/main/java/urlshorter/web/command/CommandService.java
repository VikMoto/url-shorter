package urlshorter.web.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandService {
    private Map<String, Command> commands;

    private Command defaultCommand;

    public CommandService() {
        this.commands = new HashMap<>();
        this.commands.put("GET /", new IndexCommand());
        this.commands.put("GET /list", new ListCommand());
        this.commands.put("GET /link/create", new GetCreateLinkCommand());
        this.commands.put("POST /link/create", new PostCreateLinkCommand());
        this.commands.put("GET /link/delete", new DeleteLinkCommand());

        this.defaultCommand = new RedirectCommand();
    }

    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        String requestURI = req.getRequestURI();
        String commandKey = req.getMethod() + " " + requestURI;
        System.out.println("commandKey = " + commandKey);
        Command command = commands.get(commandKey);

        if (command != null) {
            command.process(req, resp, engine);
        } else {
           defaultCommand.process(req, resp, engine);
        }
    }
}
