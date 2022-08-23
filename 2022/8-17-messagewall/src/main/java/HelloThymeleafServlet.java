import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-08-23
 * Time: 17:30
 */
@WebServlet("/helloThymeleaf")
public class HelloThymeleafServlet extends HttpServlet {
    private TemplateEngine engine = new TemplateEngine();
    @Override
    public void init() throws ServletException {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(this.getServletContext());
        resolver.setPrefix("WEB-INF/template/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");
        engine.setTemplateResolver(resolver);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");

        WebContext webContext = new WebContext(req, resp, this.getServletContext());
        webContext.setVariable("message", message);

        String html = engine.process("hello", webContext);
        System.out.println(html);
        resp.getWriter().write(html);
    }
}
