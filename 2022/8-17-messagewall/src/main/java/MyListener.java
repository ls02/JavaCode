
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-08-23
 * Time: 23:36
 */
@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext 初始化");
        ServletContext context = servletContextEvent.getServletContext();
        context.setAttribute("message", "初始化的消息");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
