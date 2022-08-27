package common;
import dao.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-08-27
 * Time: 17:20
 */
public class Util {
    public static User checkLoginStatus(HttpServletRequest req) {
//       此处判定当前是否处于登录状态，如果能拿到 Session, 并且拿到 Session 里的 user 对象就认为当前为登录的状态
        HttpSession session = req.getSession(false);
        if (session == null) {
//            未登录的状态
            return null;
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
//            未登录状态
            return null;
        }

        return user;
    }
}
