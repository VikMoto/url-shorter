package urlshorter.web.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import urlshorter.link.Link;
import urlshorter.link.LinkService;
import urlshorter.serviceprovider.ServiceProvider;

import java.io.IOException;

public class RedirectCommand implements Command{

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        String shortLink = req.getRequestURI().replace("/","");
        System.out.println("RedirectCommand - shortLink = " + shortLink);

        LinkService linkService = ServiceProvider.get(LinkService.class);

        Link byShortLink = linkService.getByShortLink(shortLink);
        byShortLink.setOpenCount(byShortLink.getOpenCount() + 1);
        linkService.update(byShortLink);
        String link = byShortLink.getLink();

        resp.sendRedirect(link);

    }
}
