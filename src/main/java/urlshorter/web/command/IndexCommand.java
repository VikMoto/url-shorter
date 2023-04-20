package urlshorter.web.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class IndexCommand implements Command{
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        resp.getWriter().write("Success");
        resp.setContentType("text/html");


        Context simpleContext = new Context(
                req.getLocale(),
//                Map.of("name", "Some Name")
                Collections.emptyMap()

        );

        engine.process("index", simpleContext, resp.getWriter());
        resp.getWriter().close();
    }
}
