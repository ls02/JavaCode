import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-08-24
 * Time: 9:50
 */
@WebListener
public class ThymeleafConfig implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        // 1. 初始化 TemplateEngine
        TemplateEngine engine = new TemplateEngine();
        // 2. 初始化 ServletContextTemplateResolver
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(context);
        resolver.setPrefix("/WEB-INF/template/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("utf-8");
        // 3. 把 resolver 和 engine 关联起来
        engine.setTemplateResolver(resolver);
        // 4. 把 engine 设置到 ServletContext 中
        context.setAttribute("engine", engine);
        System.out.println("TemplateEngine 初始化完毕!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
