import com.fasterxml.jackson.databind.ObjectMapper;

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
 * Date: 2022-08-17
 * Time: 16:49
 */

class Message {
    public String from;
    public String to;
    public String message;
}

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Message> messageList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        Message message = new Message();
        message.from = "白猫";
        message.to = "黑猫";
        message.message = "喵";

        messageList.add(message);
    }

    //    这方法是用来从服务器上获取到消息数据
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(resp.getWriter(), messageList);
    }

//    这个方法是用来处理从客户端提交数据给服务器

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
        messageList.add(message);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write("{\"ok\": 1");
    }
}
