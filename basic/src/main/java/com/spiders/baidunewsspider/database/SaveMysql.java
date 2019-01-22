package com.spiders.baidunewsspider.database;

import com.spiders.baidunewsspider.bean.NewsData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
 * @PackageName com.spiders.baidunewsspider.database
 * @Author joel
 * @Date 2019/1/21 10:47
 **/
public class SaveMysql {
    private static Connection connection = null;
    private static Properties properties = new Properties();

    private static String userDir = System.getProperties().getProperty("user.dir");
    private static String DS = File.separator;

    private static String mysql_driver = null;
    private static String mysql_url = null;
    private static String mysql_user = null;
    private static String mysql_password = null;

    public static void insert(List<NewsData> infolist) {
        File input = new File(userDir + DS + "config" + DS + "mysql.properties");

        try {
            properties.load(new FileInputStream(input));
            mysql_driver = properties.getProperty("driver");
            mysql_url = properties.getProperty("url");
            mysql_user = properties.getProperty("user");
            mysql_password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(mysql_url, mysql_user, mysql_password);
            // PrepareStatement是 Statement的子接口，可以传入带占位符的 SQL语句，提供了补充占位符变量的方法，还可以防止SQL注入
            PreparedStatement pst = null;
            String sql = "INSERT INTO `baidunews_java`(`title`,`url`,`source`,`time`, `content`) VALUES (?, ?, ?, ?, ?)";
            pst = connection.prepareStatement(sql);

            for (NewsData info : infolist) {
                // 查询是否存在相同的新闻（url）
                String querySql = "select `url` from `baidunews_java` where `url`=?";
                PreparedStatement pst2 = connection.prepareStatement(querySql);
                pst2.setString(1, info.getUrl());
                ResultSet result = pst2.executeQuery();

                // 不存在对应 url 的新闻就插入
                if (!result.next()) {
                    // setXxx()方法设置占位符的值，索引从1开始 setLong() 存时间戳
                    pst.setString(1, info.getTitle());

                    // setString() 格式化字符串
                    pst.setString(2, info.getUrl());
                    pst.setString(3, info.getSource());
                    pst.setLong(4, info.getTime());
                    pst.setString(5, info.getContent());

                    // 执行SQL语句
                    pst.executeUpdate();
                } else {
                    System.out.println("新闻已存在");
                }
                pst2.close();
            }
            System.out.println("=====");
            pst.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
