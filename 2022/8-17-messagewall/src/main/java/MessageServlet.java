import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA..
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
//    private List<Message> messageList = new ArrayList<>();
    private String filePath = "e:/messages.txt";

    //    这方法是用来从服务器上获取到消息数据
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        List<Message> messageList = load();
        objectMapper.writeValue(resp.getWriter(), messageList);
    }



//    这个方法是用来处理从客户端提交数据给服务器

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
        save(message);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write("{\"ok\": 1");
    }

    private void save(Message message){
        System.out.println("向文件中写入数据!");
        try (FileWriter fileWriter = new FileWriter(filePath, true)){
            fileWriter.write(message.from + "\t" + message.to + "\t" + message.message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Message> load() {
        List<Message> messageList = new ArrayList<>();
        System.out.println("从文件加载！");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }

                String[] tokens = line.split("\t");
                Message message = new Message();
                message.from = tokens[0];
                message.to = tokens[1];
                message.message = tokens[2];
                messageList.add(message);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return messageList;
    }
}
