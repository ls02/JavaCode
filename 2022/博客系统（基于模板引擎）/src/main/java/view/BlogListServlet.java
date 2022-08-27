package view;

import common.Util;
import dao.Blog;
import dao.BlogDao;
import dao.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-08-27
 * Time: 14:11
 */
@WebServlet("/blog_list.html")
public class BlogListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

//        针对登录状态的检测，未登录时则重定向到登录页面
        User user = Util.checkLoginStatus(req);
        if (user == null) {
            System.out.println("当前用户未登录");
            resp.sendRedirect("login.html");
            return;
        }

        // 1. 从数据库中拿到所有的博客列表
        BlogDao blogDao = new BlogDao();
        List<Blog> blogs = blogDao.selectAll();
        // 2. 通过模板引擎, 渲染页面
        ServletContext context = this.getServletContext();
        TemplateEngine engine = (TemplateEngine) context.getAttribute("engine");
        WebContext webContext = new WebContext(req, resp, context);
        webContext.setVariable("blogs", blogs);
        webContext.setVariable("user", user);
        String html = engine.process("blog_list", webContext);
        resp.getWriter().write(html);
    }
}
