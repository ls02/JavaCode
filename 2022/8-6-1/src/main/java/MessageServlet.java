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
 * Date: 2022-08-06
 * Time: 17:27
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

    public void init() throws ServletException {
//        在这里面给 messageList 构造几个测试数据，方便来观察，
//        这个数据的构造可以写到 init 里，也可以写道构造方法里
        Message message = new Message();
        message.from = "黑猫";
        message.to = "白猫";
        message.message = "喵";
        messageList.add(message);

        message = new Message();
        message.from = "橘猫";
        message.to = "黑猫";
        message.message =  "喵呜";
        messageList.add(message);
    }

//    这个方法用来处理，从服务器获取的消息数据
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(resp.getWriter(), messageList);
    }

//    这个方法用来处理，从客户端提交数据给服务器
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
        messageList.add(message);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write("{\"OK\": 1}");
    }
}
