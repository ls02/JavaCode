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
 * Date: 2022-08-05
 * Time: 15:20
 */

@WebServlet("/getParameterServlet")
public class GetParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        String userId = req.getParameter("userId");
        String classId = req.getParameter("classId");
//        很多时候我们需要对 query String 进行判定是否存在，判定代码就得写成这种形式
        if (userId == null || classId.equals("")) {
//            参数不存在
//            处理不存在的情况
        }
        resp.getWriter().write(String.format("userId: %s; classId: %s <br>",
                userId, classId));
    }
}
