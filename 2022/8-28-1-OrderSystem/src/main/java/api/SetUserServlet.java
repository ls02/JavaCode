package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.UserDao;
import util.OrderSystemException;
import util.OrderSystemUtil;

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
 * Date: 2022-09-05
 * Time: 22:15
 */
@WebServlet("/setUser")
public class SetUserServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    static class Response {
        public int ok;
        public String reason;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        OrderServlet.Response response = new OrderServlet.Response();

        try {
            //      1. 读取 body 中的数据
            String body = OrderSystemUtil.readBody(req);
//      2. 把 body 数据解析成 Request 对象（GSON）
            RegisterServlet.Request request = gson.fromJson(body, RegisterServlet.Request.class);

            UserDao userDao = new UserDao();
            String name = req.getParameter("name");
            String numb = request.numb;
            String address = request.address;
            int flags = Integer.parseInt(request.flags);
            String password = request.password;
//            flags 为 1 是修改密码
//            flags 为 2 是修改地址
//            flags 为 3 是修改手机号
            if (flags == 1) {
                userDao.setPassword(name, password);
            } else if (flags == 2) {
                userDao.setAddress(name, address);
            } else if (flags == 3) {
                userDao.setNumb(name, numb);
            } else {
                throw new OrderSystemException("未定义的标识符");
            }

            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        }finally {
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }
}
