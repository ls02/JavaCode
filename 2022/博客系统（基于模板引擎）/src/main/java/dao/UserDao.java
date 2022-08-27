package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-08-27
 * Time: 11:05
 */
public class UserDao {
    public void insert(User user) {
        System.out.println("插入用户！");
       Connection connection = null;
       PreparedStatement statement = null;

       try {
//           1. 和数据库连接
           connection = DBUtil.getConnection();
//           2. 拼装 SQL
           String sql = "insert into user values (null, ?, ?)";
           statement = connection.prepareStatement(sql);
           statement.setString(1, user.getUserName());
           statement.setString(2, user.getPassword());
//           3. 执行 SQL
           int ret = statement.executeUpdate();
           if (ret == 1) {
               System.out.println("插入用户成功！");
           } else {
               System.out.println("插入用户失败！");
           }

       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           DBUtil.close(connection, statement, null);
       }
    }

    public User selectByName(String username){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
//            1. 和数据库建立连接
            connection = DBUtil.getConnection();
//            2. 拼装 SQL
            String sql = "select * from user where username = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
//            3. 执行 SQL
            resultSet = statement.executeQuery();
//            4. 遍历结果集合
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            5. 释放资源
            DBUtil.close(connection, statement, resultSet);
        }

        return null;
    }

    public User selectById(int userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
//            1. 和服务器建立连接
            connection = DBUtil.getConnection();
//            2. 拼装 SQL
            String sql = "select * from user where userId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
//            3. 执行 SQL
            resultSet = statement.executeQuery();
//            4. 遍历结果集合
            if (resultSet.next()) {

                User user = new User();
                user.setUserId(resultSet.getInt("userid"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            5. 释放资源
            DBUtil.close(connection, statement, resultSet);
        }

        return null;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();

//        User user = new User();
//        user.setUserName("admin");
//        user.setPassword("123");
//        userDao.insert(user);

//        User user = userDao.selectByName("admin");
//        System.out.println(user);

        User user = userDao.selectById(1);
        System.out.println(user);
    }
}
