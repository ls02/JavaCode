package model;

import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-08-28
 * Time: 14:42
 */
public class UserDao {
    public void add(User user) throws OrderSystemException {
//      1. 和数据库建立连接
        Connection connection = DBUtil.getConnection();
//        2. 拼装 SQL 语句
        String sql = "insert into user values(null, ?, ?, ?)";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getPassword());
            statement.setInt(2, user.getIsAdmin());
            statement.setString(3, user.getName());

//          3. 执行 SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("插入用户失败！");
            }

            System.out.println("插入用户成功! ");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //        4.释放资源
            DBUtil.close(connection, statement, null);
        }
    }

    public User selectByName(String name) throws OrderSystemException {
//        1. 和数据库连接
        Connection connection = DBUtil.getConnection();
//        2. 拼装 SQL
        String sql = "select * from user where name = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
//            3. 执行 SQL
            resultSet = statement.executeQuery();
//            4. 遍历结果
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getInt("isAdmin"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按姓名查找用户失败! ");
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }

        return null;
    }

    public void delete(int dishId) throws OrderSystemException {
//        1. 获取数据库连接
        Connection connection = DBUtil.getConnection();
//        2. 评传 SQL
        String sql = "delete from dishes where dishId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, dishId);
//            3. 执行 SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("删除菜品失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("删除菜品失败！");
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    public List<Dish> selectAll() {
        List<Dish> dishes = new ArrayList<Dish>();
//        1. 和数据库连接
        Connection connection = DBUtil.getConnection();
//        2. 拼装 SLQQL
        String sql = "select * from dishes";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
//            3. 执行 SQL
            resultSet = statement.executeQuery();
//            4. 遍历结果集
            while (resultSet.next() ) {
                Dish dish = new Dish();
                dish.setDishId(resultSet.getInt("dishId"));
                dish.setName(resultSet.getString("name"));
                dish.setPrice(resultSet.getInt("price"));
                dishes.add(dish);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }

        return dishes;
    }

    public User selectById(int userId) throws OrderSystemException {
        // 1. 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 2. 拼装 SQL
        String sql = "select * from user where userId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            // 3. 执行 SQL
            resultSet = statement.executeQuery();
            // 4. 遍历结果集, userId 是主键. 不会重复的. 最多只能查到一条记录
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getInt("isAdmin"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按 id 查找用户失败");
        } finally {
            // 5. 断开连接
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    public static void main(String[] args) throws OrderSystemException {
        UserDao userDao = new UserDao();

//        User user = new User();
//        user.setName("张三");
//        user.setPassword("123456");
//        user.setIsAdmin(0);
//        userDao.add(user);

        User user = userDao.selectByName("张三");
        System.out.println("按照名字来查找");
        System.out.println(user);

        user = userDao.selectById(1);
        System.out.println("按照 ID 查找");
        System.out.println(user);
    }
}
