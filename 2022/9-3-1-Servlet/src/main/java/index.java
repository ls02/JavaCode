import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-09-03
 * Time: 17:15
 */
@WebServlet("/index")
public class index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        HttpSession httpSession = req.getSession(false);
        if (httpSession == null) {
            resp.sendRedirect("login.html");
            return;
        }

        String username = (String) httpSession.getAttribute("username");
        Integer loginConst = (Integer) httpSession.getAttribute("loginConst");
        loginConst = loginConst + 1;
        httpSession.setAttribute("loginConst", loginConst);

        StringBuilder html = new StringBuilder();
        html.append("<div>用户名：" + username + "</div>");
        html.append("<div>用户登录次数：" + loginConst + "</div>");

        resp.getWriter().write(html.toString());
    }
}
