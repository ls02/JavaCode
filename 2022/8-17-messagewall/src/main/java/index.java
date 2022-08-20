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
 * Date: 2022-08-20
 * Time: 17:36
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

        String userName = (String) httpSession.getAttribute("userName");
        Integer logInCount = (Integer) httpSession.getAttribute("logInCount");

        logInCount++;
        httpSession.setAttribute("logInCount", logInCount);

        StringBuffer html = new StringBuffer();
        html.append("<div>用户: " + userName + "</div>");
        html.append("div>用户访问次数: " + logInCount + "</div>");
        resp.getWriter().write(html.toString());
    }
}
