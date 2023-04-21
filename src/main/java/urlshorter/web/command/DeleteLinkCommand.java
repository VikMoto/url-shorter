package urlshorter.web.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import urlshorter.link.Link;
import urlshorter.link.LinkService;
import urlshorter.serviceprovider.ServiceProvider;

import java.io.IOException;

public class DeleteLinkCommand implements Command{

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        String shortLink = req.getParameter("shortLink");
        System.out.println("DeleteLinkCommand - shortLink = " + shortLink);

        LinkService linkService = ServiceProvider.get(LinkService.class);

        linkService.deleteByShortLink(shortLink);

        resp.sendRedirect("/list");

    }
}
