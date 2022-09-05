package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.User;
import model.UserDao;
import util.OrderSystemException;
import util.OrderSystemUtil;

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
 * Date: 2022-09-05
 * Time: 14:35
 */
@WebServlet("/userAddress")
public class UserAddressServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    static class Response {
        public int ok;
        public String reason;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        OrderServlet.Response response = new OrderServlet.Response();

        try {
        //            1. 检测登录状态
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("您尚未登陆");
            }
            User user = (User) session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("您尚未登陆");
            }

            String userId = req.getParameter("userId");
            User userString = new User();
            UserDao userDao = new UserDao();
            userString =  userDao.selectById(Integer.parseInt(userId));

            if (userString == null) {
                throw new OrderSystemException("当前用户不存在");
            }

            String jsonString = gson.toJson(userString);
            System.out.println(jsonString);
            response.ok = 1;
            response.reason = "";

            resp.getWriter().write(jsonString);
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        }
    }

}
