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
 * Time: 17:19
 */
@WebServlet("/login")
public class LogIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        if (!"zhangsan".equals(userName) || !"123".equals(password)) {
            resp.getWriter().write("登录失败");

            return;
        }

        System.out.println("登录成功");

        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("userName", "zhangsan");
        httpSession.setAttribute("logInCount", Integer.valueOf(0));

        resp.sendRedirect("index");
    }
}
