package urlshorter.web.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;

import java.io.IOException;

public interface Command {
    void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException;
}
