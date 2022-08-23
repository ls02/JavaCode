import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-08-23
 * Time: 17:01
 */
@WebServlet("/guessNum")
public class GuessServlet extends HttpServlet {
    private TemplateEngine engine = new TemplateEngine();
    private int toGuess = 0;
    private int count = 0;

    @Override
    public void init() throws ServletException {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(this.getServletContext());

        resolver.setPrefix("/WEB-INF/template/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");
        engine.setTemplateResolver(resolver);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        Random random = new Random();
        toGuess = random.nextInt(100) + 1;
        count = 0;

//        开启一局新的游戏
        WebContext webContext = new WebContext(req, resp, getServletContext());
        webContext.setVariable("newGame", true);
        engine.process("guessNum", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        String parameter = req.getParameter("num");
        int num = Integer.parseInt(parameter);

        String result = "";

        if (num < toGuess) {
            result = "猜小了";
        } else if (num > toGuess){
            result = "菜大了";
        } else {
            result = "猜对了";
        }

        count++;

        WebContext webContext = new WebContext(req, resp, getServletContext());
        webContext.setVariable("newGame", false);
        webContext.setVariable("result", result);
        webContext.setVariable("count", count);
        engine.process("guessNum", webContext, resp.getWriter());
    }
}
