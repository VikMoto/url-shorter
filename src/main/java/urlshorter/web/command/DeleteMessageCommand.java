package urlshorter.web.command;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;

import java.io.IOException;

public class DeleteMessageCommand implements Command {

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        String id = req.getParameter("id");
//        InMemoryMessageStorage.getINSTANCE().deleteById(id);
        resp.sendRedirect("/forum");
    }
}
