import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
//    private List<Message> messageList = new ArrayList<>();

//    这个是保存文件的路径
//    private String filePath = "d:/message.txt";

//    public void init() throws ServletException {

//        在这里面给 messageList 构造几个测试数据，方便来观察，
//        这个数据的构造可以写到 init 里，也可以写道构造方法里
//        Message message = new Message();
//        message.from = "黑猫";
//        message.to = "白猫";
//        message.message = "喵";
//        messageList.add(message);
//
//        message = new Message();
//        message.from = "橘猫";
//        message.to = "黑猫";
//        message.message =  "喵呜";
//        messageList.add(message);
//    }

//    这个方法用来处理，从服务器获取的消息数据
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
//        objectMapper.writeValue(resp.getWriter(), messageList);
    }

//    这个方法用来处理，从客户端提交数据给服务器
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
        List<Message> messageList = load();
        objectMapper.writeValue(resp.getWriter(), messageList);
//        messageList.add(message);

//        在这里，要进行一个 “写文件” 操作
        save(message);

        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write("{\"OK\": 1}");
    }

    private List<Message> load() {
//        这个方法负责读取文件，把读到的数据获取到之后，放到 List<Message> 中
        List<Message> messageList = new ArrayList<>();
//        System.out.println("从文件中加载！");
//
////        此处我们需要按行读取， FileReader 本身不支持，需要套上一层 BufferedReader
//        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
//            while (true) {
//                String line = bufferedReader.readLine();
//                if (null == line) {
//                    break;
//                }
//
////                如果读取到了 line 的内容就把 line 解析成一个 Message 对象
//                String[] tokens = line.split("\t");
//                Message message  = new Message();
//                message.from = tokens[0];
//                message.to = tokens[1];
//                message.message = tokens[2];
//                messageList.add(message);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
        System.out.println("从数据库读取数据！");

        return messageList;

    }

    private void save(Message message) {
//        System.out.println("向文件中写入数据！");
//        try (FileWriter fileWriter = new FileWriter(filePath)) {
////            写入文件的格式有很多方式，可以直接写 json ，也可以使用行文本（每个记录占一行，字段之间使用分隔符区分）
//            fileWriter.write(message.from + "\t" + message.to + "\t" + message.message + "\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println("向数据库中写入数据！");
//        1.先和数据库建立连接
        Connection connection = null;
        PreparedStatement statement = null;
        try {
//            1.显赫数据库建立连接
            connection = DBUtil.getConnection();
//            2.构造拼装 SQL
            String sql =  "insert into message value s (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, message.from);
            statement.setString(2, message.to);
            statement.setString(3, message.message);

//            3.执行 SQL
            int ret = statement.executeUpdate();
            if (ret == 1) {
                System.out.println("插入成功！");
            } else {
                System.out.println("插入失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }
}
