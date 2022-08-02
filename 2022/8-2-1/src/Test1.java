import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-08-02
 * Time: 15:34
 */
public class Test1 {
    private Socket socket;
    private String ip;
    private int port;

    public void HttpClient(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        socket = new Socket(ip, port);
    }

    public String get(String url) throws IOException {
        StringBuilder request = new StringBuilder();
//        构造首行
        request.append("GET" + url + "HTTP/1.1\n");

//        构造 header
        request.append("Host: " + ip + ":" + port + "\n");
//        构造空行
        request.append("\n");
//        get请求不需要 body ，就构造完了。
        OutputStream outputStream = socket.getOutputStream();
//        outputStream 是一个字节流，以字节为单位进行写入，因此需要把 StringBuilder 转换成 byte[]
        outputStream.write(request.toString().getBytes());

//        读取响应
        InputStream inputStream = socket.getInputStream();
//            搞一个 1M 大小的缓冲区，用来存放响应数据
        byte[] buffer = new byte[1024 * 1024];
//        n 表示实际读到的字节数
        int n = inputStream.read(buffer);

        return new String(buffer, 0, n, "utf-8");
    }

//    和刚才的 get 基本一致，只是多了一步构造 body
    public String post(String url, String body) throws IOException {
        StringBuilder request = new StringBuilder();
//        构造首行
        request.append("POST" + url + "HTTP/1.1\n");
//        构造 header
        request.append("HOST" + ip + ":" + port + "\n");
        request.append("Content-Type: text/plain\n");
        request.append("Content-Length: " + body.getBytes().length + "\n");
//      构造空行
        request.append("\n");
//        构造 body
        request.append(body);

//        发送请求
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(request.toString().getBytes());

//        读取响应
        InputStream inputStream =  socket.getInputStream();
        byte[] buffer =  new byte[1024 * 1024];
        int n = inputStream.read(buffer);

        return new String(buffer, 0, n, "utf-8");
    }

    public static void main(String[] args) throws IOException {
//        HttpClient httpClient = new HttpClient("42.192.83.143", 8089);
//        String resp = httpClient.get("/AjaxMockServer/info");
//        System.out.println(resp);


    }
}
