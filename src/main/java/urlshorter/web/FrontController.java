package urlshorter.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import urlshorter.service.DatabaseInitService;
import urlshorter.web.command.CommandService;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/*")
public class FrontController extends HttpServlet {
    private TemplateEngine engine;
    private CommandService commandService;

    @Override
    public void init() {
        new DatabaseInitService().initDb();

        engine = new TemplateEngine();


//        FileTemplateResolver resolver = new FileTemplateResolver();
//        resolver.setPrefix("/HOME/url-shorter/build/resources/main/templates/");
////        resolver.setPrefix("/src/main/webapp/WEB-INF/templates");
//        resolver.setSuffix(".html");
//        resolver.setTemplateMode("HTML5");
//        resolver.setOrder(engine.getTemplateResolvers().size());
//        resolver.setCacheable(false);

        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCacheable(false);
        engine.addTemplateResolver(resolver);
        commandService = new CommandService();
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       resp.getWriter().write("Success");
//
//        Map<String, String[]> parameterMap = req.getParameterMap();
//
//        Map<String, Object> params = new LinkedHashMap<>();
//        for (Map.Entry<String, String[]> keyValue : parameterMap.entrySet()) {
//            params.put(keyValue.getKey(), keyValue.getValue()[0]);
//        }
//
//        Context simpleContext = new Context(
//                req.getLocale(),
////                Map.of("name", "Some Name")
//                Map.of("queryParams", params)
//
//        );
//        resp.setContentType("text/html");
//        engine.process("index", simpleContext, resp.getWriter());
//        resp.getWriter().close();
//    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        commandService.process(req,resp,engine);
    }
}
