package urlshorter.web.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import urlshorter.link.LinkService;
import urlshorter.serviceprovider.ServiceProvider;

import java.io.IOException;
import java.util.Collections;

public class GetCreateLinkCommand implements Command{
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        resp.setContentType("text/html");

        Context simpleContext = new Context(
                req.getLocale(),
                Collections.emptyMap()
        );

        engine.process("create-link", simpleContext, resp.getWriter());
        resp.getWriter().close();
    }
}
