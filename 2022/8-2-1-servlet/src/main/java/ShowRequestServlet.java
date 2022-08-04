import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-08-03
 * Time: 17:55
 */
@WebServlet("/showRequest")
public class ShowRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
//        把生成的响应的 body 放到 respBody 中
        StringBuilder respBody = new StringBuilder();
        respBody.append(req.getProtocol());
        respBody.append("<br>");
        respBody.append(req.getMethod());
        respBody.append("<br>");
        respBody.append(req.getRequestURI());
        respBody.append("<br>");
        respBody.append(req.getContextPath());
        respBody.append("<br>");
        respBody.append(req.getQueryString());
        respBody.append("<br>");

        respBody.append("<h3>headers:</h3>");
        Enumeration<String> headerNames = req.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            respBody.append(headerName + ":");
            respBody.append(req.getHeader(headerName));
            respBody.append("<br>");
        }

        resp.getWriter().write(respBody.toString());
    }
}
