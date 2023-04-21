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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListCommand implements Command{
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        resp.setContentType("text/html");
        LinkService linkService = ServiceProvider.get(LinkService.class);

//        Link link = Link.builder()
//                .shortLink("f4h4F")
//                .link("https://google.com")
//                .build();
//        linkService.save(link);
        List<Link> links;

        if (req.getParameterMap().containsKey("query")) {
            //todo seqarch
            links = linkService.search(req.getParameter("query"));
        }else {
           links = linkService.listAll();
        }

        Map<String, Object> params = new HashMap<>();
        params.put("links", links);
        params.put("query", req.getParameter("query"));

        Context simpleContext = new Context(req.getLocale(),params);



        engine.process("list", simpleContext, resp.getWriter());
        resp.getWriter().close();
    }
}
