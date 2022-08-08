import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-08-07
 * Time: 15:41
 */
public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/1?useSSL=false&characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "2222";
    private static DataSource dataSource = null;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new MysqlDataSource();
            ((MysqlDataSource)dataSource).setURL(URL);
            ((MysqlDataSource)dataSource).setUser(USERNAME);
            ((MysqlDataSource)dataSource).setPassword(PASSWORD);
        }

        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
//        return getDataSource().getConnection();
    }
}
