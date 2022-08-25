import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-08-25
 * Time: 14:47
 */
class Image {
    public String name;
    public String url;
}

@WebServlet("/image")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Image> images = loadImage();

        ServletContext context = this.getServletContext();
        TemplateEngine engine = (TemplateEngine) context.getAttribute("engine");
        WebContext webContext = new WebContext(req, resp, context);
        webContext.setVariable("images", images);
        String html = engine.process("images", webContext);
        resp.getWriter().write(html);
    }

    private List<Image> loadImage() {
        List<Image> images = new ArrayList<>();
        ServletContext context = this.getServletContext();
        String path = context.getRealPath("/image");
        System.out.println(path);

        File imageRoot = new File(path);
        File[] files = imageRoot.listFiles();

        for (File f : files) {
            Image image = new Image();
            image.name = f.getName();
            image.url = "image/" + f.getName();
            images.add(image);
        }

        return images;
    }
}
