import com.sun.deploy.net.MessageHeader;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-08-24
 * Time: 9:58
 */
class Message {
    public String from;
    public String to;
    public String message;

    public Message(String from, String to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
    }
}

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    private List<Message> messages = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        // 读取 messages 列表, 根据列表的数据, 结合网页模板, 来构造出一个页面, 返回给浏览器.
        ServletContext context = getServletContext();
        TemplateEngine engine = (TemplateEngine) context.getAttribute("engine");
        WebContext webContext = new WebContext(req, resp, context);
        webContext.setVariable("messages", messages);
        String html = engine.process("messageWall", webContext);
        resp.getWriter().write(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理请求的时候, 需要给请求对象也设置一下字符集.
        req.setCharacterEncoding("utf-8");
        // resp.setCharacterEncoding("utf-8");
        // 处理请求的内容, 把读到的数据给解析, 得到 from, to, message, 构造出 Message 对象, 插入到 List 里面
        // 此处得到的请求的内容, 是 URL encode 的结果. Servlet 也不知道这个 encode 的结果是按照 UTF8 还是其他字符集进行编码的
        String from = req.getParameter("from");
        String to = req.getParameter("to");
        String msg = req.getParameter("message");
        Message message = new Message(from, to, msg);
        messages.add(message);
        // 直接来一个 重定向 操作, 重定向到 GET 版本的 /message , 就可以自动的重新获取到消息列表了
        resp.sendRedirect("message");
    }
}
