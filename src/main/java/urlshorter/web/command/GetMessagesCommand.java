package urlshorter.web.command;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.Map;

public class GetMessagesCommand implements Command{

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
//        resp.setContentType("text/html");
//        InMemoryMessageStorage messageStorage = InMemoryMessageStorage.getINSTANCE();
//
//        Context simpleContext = new Context(
//                req.getLocale(),
//                Map.of("messages", messageStorage.getAllMessage())
//
//        );
//        engine.process("forum", simpleContext, resp.getWriter());
//        resp.getWriter().close();
    }
}
