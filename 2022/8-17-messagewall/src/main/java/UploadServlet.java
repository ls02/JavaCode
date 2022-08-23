import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-08-23
 * Time: 16:29
 */
@MultipartConfig
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("MyImage");

        System.out.println(part.getSubmittedFileName());
        System.out.println(part.getContentType());
        System.out.println(part.getSize());

        part.write("E:/temp/Image.jpg");

        resp.getWriter().write("upload ok");
    }
}
