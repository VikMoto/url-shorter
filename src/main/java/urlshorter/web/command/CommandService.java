package urlshorter.web.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandService {
    private Map<String, Command> commands;

    public CommandService() {
        this.commands = new HashMap<>();
        this.commands.put("GET /", new IndexCommand());
        this.commands.put("GET /list", new ListCommand());
    }

    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        String requestURI = req.getRequestURI();
        String commandKey = req.getMethod() + " " + requestURI;
        System.out.println("commandKey = " + commandKey);
        commands.get(commandKey).process(req, resp, engine);
    }
}
