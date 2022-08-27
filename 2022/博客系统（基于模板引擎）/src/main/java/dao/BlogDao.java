package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-08-26
 * Time: 18:56
 */
// 通过这个 类 来封装对于 Blog 表的操作
// 1. 新增一个博客
// 2. 获取到所有博客列表.
// 3. 根据博客 id 获取到指定博客.
// 4. 根据博客  id 删除博客~
public class BlogDao {
    public void insert(Blog blog) {
        System.out.println("插入一个博客");

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1. 建立连接
            connection = DBUtil.getConnection();
            // 2. 构造 SQL 语句
            String sql = "insert into blog values(null, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContent());
            statement.setTimestamp(3, blog.getPostTime());
            statement.setInt(4, blog.getUserId());
            // 3. 执行 SQL
            int ret = statement.executeUpdate();
            if (ret == 1) {
                System.out.println("插入博客成功!");
            } else {
                System.out.println("插入博客失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    public List<Blog> selectAll() {
        System.out.println("查找所有博客");
        List<Blog> blogs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 1. 和数据库建立连接
            connection = DBUtil.getConnection();
            // 2. 拼装 SQL
            String sql = "select * from blog order by postTime desc";
            statement = connection.prepareStatement(sql);
            // 3. 执行 SQL
            resultSet = statement.executeQuery();
            // 4. 遍历结果集合
            while (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                String content = resultSet.getString("content");
                if (content.length() > 90) {
                    content = content.substring(0, 90) + "......";
                }
                blog.setContent(content);
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blog.setUserId(resultSet.getInt("userId"));
                blogs.add(blog);
            }
            return blogs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. 释放资源
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    public Blog selectOne(int blogId) {
        System.out.println("查找指定博客");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. 和数据库建立连接
            connection = DBUtil.getConnection();
            // 2. 构造 SQL
            String sql = "select * from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, blogId);
            // 3. 执行 SQL
            resultSet = statement.executeQuery();
            // 4. 遍历结果集合, 由于此处是基于 自增主键 来查询的. 查询结果要么是 1 条记录, 要么是 0 条记录
            if (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blog.setUserId(resultSet.getInt("userId"));
                return blog;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    public void delete(int blogId) {
        System.out.println("删除指定博客");
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1. 建立连接
            connection = DBUtil.getConnection();
            // 2. 拼装 SQL
            String sql = "delete from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, blogId);
            // 3. 执行 SQL
            int ret = statement.executeUpdate();
            if (ret == 1) {
                System.out.println("删除成功!");
            } else {
                System.out.println("删除失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }


    public static void main(String[] args) {
        BlogDao blogDao = new BlogDao();

        //1. 测试一下插入
//        Blog blog = new Blog();
//        blog.setTitle("我的第一篇博客");
//        blog.setContent("从今天开始，我要好好敲代码  Lorem ipsum, dolor sit amet consectetur adipisicing elit. Voluptate facilis rerum deserunt laudantium unde necessitatibus praesentium veniam dolorum non doloribus mollitia id pariatur nemo ad porro explicabo, voluptatem beatae cumque.");
//        blog.setUserId(1);
//        blog.setPostTime(new Timestamp(System.currentTimeMillis()));
//        blogDao.insert(blog);

//        List<Blog> blogs = blogDao.selectAll();
//        System.out.println(blogs);

//        blogDao.delete(1);
//
//        Blog blog = blogDao.selectOne(1);
//        System.out.println(blog);
    }
}
