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
 * Date: 2022-08-09
 * Time: 16:17
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.先从请求的 body 中读取用户名和用户密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        2.判定一下用户密码是否正确（此处就不读数据库了，直接固定用户密码，就是 zhagnsna 123
        if (!"zhagnsan".equals(username) || ! "123".equals(password)) {
//            登录失败
            resp.getWriter().write("登录失败！");

            return;
        }

//        3. 登录成功，创建出一个会话来,会话不存在就创建
//        会话是根据请求来的 sessionId 来查的，sessionID 是在 Cookie 中的。
//        但是此处是首次登录此时请求中是没有 Cookie （Cookie 是服务器返回）
//        此处就会触发找不到就创建这样的流程
//        同时这里进行的操作：先创建出一个 HttpSession 对象（作为 vlaue）
//        再生成一个随机的字符串作为 sessionId（作为 key）
//        把这个 key 和 value 插入到 hash 表中
//        同时把这个生成的sessionId通过 Set-Cookie 字段返回给浏览器
        HttpSession httpSession = req.getSession(true);
//        此处还可以存入程序员自定义的数据，可以存入身份信息（用户和登陆次数）
        httpSession.setAttribute("username", "zhangsan");
        httpSession.setAttribute("loginCount", Integer.valueOf(0));
//        4.让页面条跳转到主页，使用重定向的方式实现即可
        resp.sendRedirect("index");
    }
}
