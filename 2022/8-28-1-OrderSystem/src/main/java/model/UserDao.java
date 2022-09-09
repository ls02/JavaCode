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
        String sql = "insert into user values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getIsAdmin());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getNumb());
            statement.setString(6, user.getProvinceIndex());
            statement.setString(7, user.getCityIndex());
            statement.setString(8, user.getDistrictIndex());
            statement.setString(9, user.getStreet());

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
                user.setAddress(resultSet.getString("address"));
                user.setNumb(resultSet.getString("numb"));
                user.setProvinceIndex(resultSet.getString("provinceIndex"));
                user.setCityIndex(resultSet.getString("cityIndex"));
                user.setDistrictIndex(resultSet.getString("districtIndex"));
                user.setStreet(resultSet.getString("street"));

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
//        2. 拼装 SQL
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
                user.setAddress(resultSet.getString("address"));
                user.setNumb(resultSet.getString("numb"));
                user.setProvinceIndex(resultSet.getString("provinceIndex"));
                user.setCityIndex(resultSet.getString("cityIndex"));
                user.setDistrictIndex(resultSet.getString("districtIndex"));
                user.setStreet(resultSet.getString("street"));

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

    public void deleteUserName(String userName) throws OrderSystemException {
        // 1. 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 2. 拼装 SQL
        String sql = "delete from user where name = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            // 3. 执行 SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("删除用户失败!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("删除用户失败！");
        } finally {
            // 5. 断开连接
            DBUtil.close(connection, statement, null);
        }
    }

    public void setPassword(String name, String password) throws OrderSystemException {
        // 1. 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 2. 拼装 SQL
        String sql = "update user set  password = ? where name = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, password);
            statement.setString(2, name);
            // 3. 执行 SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("修改密码失败");
            }
            System.out.println("修改成功!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("修改密码失败");
        } catch (OrderSystemException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    public void setAddress(String name, String address) throws OrderSystemException {
        // 1. 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 2. 拼装 SQL
        String sql = "update user set address = ? where name = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, address);
            statement.setString(2, name);
            // 3. 执行 SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("修改地址失败");
            }
            System.out.println("修改成功!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("修改地址失败");
        } catch (OrderSystemException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    public void setNumb(String name, String numb) throws OrderSystemException {
        // 1. 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 2. 拼装 SQL
        String sql = "update user set numb = ? where name = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, numb);
            statement.setString(2, name);
            // 3. 执行 SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("修改手机号失败");
            }
            System.out.println("修改成功!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("修改手机号失败");
        } catch (OrderSystemException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    public void setProvinceIndex(String name, String provinceIndex) throws OrderSystemException {
        // 1. 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 2. 拼装 SQL
        String sql = "update user set provinceIndex = ? where name = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, provinceIndex);
            statement.setString(2, name);
            // 3. 执行 SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("修改失败");
            }
            System.out.println("修改成功!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("修改失败");
        } catch (OrderSystemException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    public void setCityIndex(String name, String cityIndex) throws OrderSystemException {
        // 1. 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 2. 拼装 SQL
        String sql = "update user set cityIndex = ? where name = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, cityIndex);
            statement.setString(2, name);
            // 3. 执行 SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("修改失败");
            }
            System.out.println("修改成功!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("修改失败");
        } catch (OrderSystemException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    public void setDistrictIndex(String name, String districtIndex) throws OrderSystemException {
        // 1. 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 2. 拼装 SQL
        String sql = "update user set districtIndex = ? where name = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, districtIndex);
            statement.setString(2, name);
            // 3. 执行 SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("修改失败");
            }
            System.out.println("修改成功!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("修改失败");
        } catch (OrderSystemException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    public void setStreet(String name, String street) throws OrderSystemException {
        // 1. 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 2. 拼装 SQL
        String sql = "update user set street = ? where name = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, street);
            statement.setString(2, name);
            // 3. 执行 SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("修改失败");
            }
            System.out.println("修改成功!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("修改失败");
        } catch (OrderSystemException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    public static void main(String[] args) throws OrderSystemException {
        UserDao userDao = new UserDao();

        User user = new User();
        user.setName("admin");
        user.setPassword("123");
        user.setIsAdmin(1);
//        user.setAddress("北京市朝阳区翻斗花园98号楼506室");
//        user.setNumb("666666");
        userDao.add(user);

//         userDao.setPassword("张三", "123");

//        userDao.deleteUserName("9");
//        User user = userDao.selectByName("9");
//        System.out.println("按照名字来查找");
//        System.out.println(user);
//
//        user = userDao.selectById(1);
//        System.out.println("按照 ID 查找");
//        System.out.println(user);

    }
}
