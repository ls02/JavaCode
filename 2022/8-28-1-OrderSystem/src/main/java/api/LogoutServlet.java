package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import util.OrderSystemException;

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
 * Date: 2022-08-30
 * Time: 15:35
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    static class Response {
        public int ok;
        public String reason;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Response response = new Response();

        try {
//            1. 根据 sessionId 找对应的 session 对象
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("您尚未登录");
            }

//            2. 把 session 对象中存的 user 信息给删掉即可（直接删掉 session）
//              如果是想删除这个 session 键值对本身就需要设置一个过期时间，让 session 立刻过期即可
            session.removeAttribute("user");
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }
}
