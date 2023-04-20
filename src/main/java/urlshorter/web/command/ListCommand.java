package urlshorter.web.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import urlshorter.link.Link;
import urlshorter.link.LinkService;
import urlshorter.serviceprovider.ServiceProvider;

import java.io.IOException;
import java.util.Collections;

public class ListCommand implements Command{
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        resp.setContentType("text/html");
        LinkService linkService = ServiceProvider.get(LinkService.class);

        Link link = Link.builder()
                .shortLink("f4h4F")
                .link("https://google.com")
                .build();
        linkService.save(link);

        Context simpleContext = new Context(
                req.getLocale(),
//                Map.of("name", "Some Name")
                Collections.singletonMap("links", linkService.listAll())
        );



        engine.process("list", simpleContext, resp.getWriter());
        resp.getWriter().close();
    }
}
