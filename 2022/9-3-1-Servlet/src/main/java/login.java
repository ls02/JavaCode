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
 * Time: 17:07
 */
@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (!"li".equals(username) || !"123".equals(password)) {
            resp.getWriter().write("登陆失败!");

            return;
        }

        System.out.println("登录成功!");
        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("username", "li");
        httpSession.setAttribute("loginConst", 0);

        resp.sendRedirect("index");
    }
}
