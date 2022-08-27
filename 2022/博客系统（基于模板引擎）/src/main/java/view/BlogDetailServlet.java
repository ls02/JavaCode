package view;

import common.Util;
import dao.Blog;
import dao.BlogDao;
import dao.User;
import dao.UserDao;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
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
 * Date: 2022-08-27
 * Time: 16:13
 */
@WebServlet("/blog_detail.html")
public class BlogDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        在请求中带有一个参数， blogId ，在这里再根据 blogId 来查数据库，得到博客的详细情况
        resp.setContentType("text/html; charset=utf-8");

//         针对登录状态的检测，未登录时则重定向到登录页面
        User user = Util.checkLoginStatus(req);
        if (user == null) {
            System.out.println("当前用户未登录");
            resp.sendRedirect("login.html");
            return;
        }

//        1. 获取到 blogId 参数
        String blogId = req.getParameter("blogId");
        if (blogId == null || "".equals(blogId)) {
            String html = "<h3>blogId 字段缺失！</h3>";
            resp.getWriter().write(html);

            return;
        }

//        2. 根据 blogId 从数据库里进行查询
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectOne(Integer.parseInt(blogId));
        if (blog == null) {
            String html = "<h3>当前博客不存在！</h3>";
            resp.getWriter().write(html);

            return;
        }

//        根据 blog 对象中 userId 去 user 表中查，查找作者信息
        UserDao userDao = new UserDao();
        User author = userDao.selectById(blog.getUserId());

//        3. 进行页面渲染
        ServletContext context = this.getServletContext();
        TemplateEngine engine = (TemplateEngine) context.getAttribute("engine");
        WebContext webContext = new WebContext(req, resp, context);
        webContext.setVariable("blog", blog);
        webContext.setVariable("user", author);
        String html = engine.process("blog_detail", webContext);
        resp.getWriter().write(html);
    }
}
