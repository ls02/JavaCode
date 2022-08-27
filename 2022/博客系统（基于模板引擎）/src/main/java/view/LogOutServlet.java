package view;

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
 * Date: 2022-08-27
 * Time: 18:02
 */
@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1. 检查当前用户是否登录
        HttpSession session = req.getSession(false);
        if (session == null) {
            String html = "<h3>您当前未登录</h3>";
            resp.getWriter().write(html);

            return;
        }

//        2. 不管 session 里没有 user， 都可以直接去删除
        req.removeAttribute("user");
//        3. 重定向到登录页面
        resp.sendRedirect("login.html");
    }
}
