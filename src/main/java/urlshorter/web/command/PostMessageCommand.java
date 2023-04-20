package urlshorter.web.command;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;

import java.io.IOException;
import java.util.UUID;

public class PostMessageCommand implements Command {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        String author = req.getParameter("author");
        String content = req.getParameter("content");
        if (author.length() > 3 && author.length() < 100 && content.length() > 100) {
            //todo handle post=request
        }
//        Message message = new Message();
//        message.setAuthor(author);
//        message.setContent(content);
//        message.setId(UUID.randomUUID().toString());
//
//        InMemoryMessageStorage.getINSTANCE().add(message);
//
//        resp.sendRedirect("/forum");
    }
}
