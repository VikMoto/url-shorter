package urlshorter.web.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import urlshorter.link.Link;
import urlshorter.link.LinkService;
import urlshorter.link.ShortLinkGenerator;
import urlshorter.serviceprovider.ServiceProvider;

import java.io.IOException;
import java.util.Collections;

public class PostCreateLinkCommand implements Command{
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        String fullUrl = req.getParameter("fullUrl");
        String shortUrl;
        LinkService linkService = ServiceProvider.get(LinkService.class);

        do {
            shortUrl = new ShortLinkGenerator().generate();

        }while (linkService.getByShortLink(shortUrl) != null);

//        = new ShortLinkGenerator().generate();


        Link link = Link.builder()
                .shortLink(shortUrl)
                .link(fullUrl)
                .build();
        linkService.save(link);
        resp.sendRedirect("/list");

    }
}
