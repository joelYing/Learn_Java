package com.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @PackageName main.database
 * @Author joel
 * @Date 2018/12/19 11:03
 **/
public class MysqlDemo {
    private static Connection connection = null;
    private static Properties properties = new Properties();
    // getProperty("user.dir") 获取当前工程的路径

    private static String userDir = System.getProperties().getProperty("user.dir");
    // File.separator 用来代替路径分隔符避免跨平台开发时的错误

    private static String DS = File.separator;
    private static String mysql_driver = null;
    private static String mysql_url = null;
    private static String mysql_user = null;
    private static String mysql_password = null;

    public static void main(String[] args) {
        // 读取
        File input = new File(userDir + DS + "config" + DS + "mysql.properties");

        try {
            properties.load(new FileInputStream(input));
            mysql_driver = properties.getProperty("driver");
            mysql_url = properties.getProperty("url");
            mysql_user = properties.getProperty("user");
            mysql_password = properties.getProperty("password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(mysql_url, mysql_user, mysql_password);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        insert(5);
//        batchInsert(5);
//        transaction(5);
//        select();
        selectRoll();
    }

    public static void insert(int count) {
        try {
            long time = System.currentTimeMillis() / 1000;
            String title = "java for insert";
            String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            connection = DriverManager.getConnection(mysql_url, mysql_user, mysql_password);
            // PrepareStatement是 Statement的子接口，可以传入带占位符的 SQL语句，提供了补充占位符变量的方法
            PreparedStatement pst = null;
            String sql = "INSERT INTO `java`(`time`,`title`,`timestamp`,`datetime`) VALUES (?, ?, ?, ?)";
            pst = connection.prepareStatement(sql);
            for (int i = 0; i < count; i++) {
                String titleStr = title + i;
                // setXxx()方法设置占位符的值，索引从1开始 setLong() 存时间戳
                pst.setLong(1, time);
                // setString() 格式化字符串
                pst.setString(2, titleStr);
                pst.setString(3, datetime);
                pst.setTimestamp(4, timestamp);
                // 执行SQL语句
                pst.executeUpdate();
            }
            System.out.println("=====");
            pst.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void batchInsert(int count) {
        // 批处理
        PreparedStatement pst = null;
        try {
            long time = System.currentTimeMillis() / 1000;
            String title = "java for insert";
            String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            connection = DriverManager.getConnection(mysql_url, mysql_user, mysql_password);
            String sql = "INSERT INTO `java`(`time`,`title`,`timestamp`,`datetime`) VALUES (?, ?, ?, ?)";
            pst = connection.prepareStatement(sql);
            for (int i = 0; i < count; i++) {
                 String titleStr = title + i;
                 pst.setLong(1, time);
                 pst.setString(2, titleStr);
                 pst.setString(3, datetime);
                 pst.setTimestamp(4, timestamp);
                 pst.addBatch();
            }
            // more addBatch()
            int[] executeNum = pst.executeBatch();
            System.out.println("batch" + executeNum.length);
            System.out.println("=====");
            pst.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void transaction(int count) {
        long time = System.currentTimeMillis() / 1000;
        String title = "java for insert";
        String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        PreparedStatement pst = null;
        try {
            connection = DriverManager.getConnection(mysql_url, mysql_user, mysql_password);
            // 开启事务
            connection.setAutoCommit(false);

            String sql = "INSERT INTO `java`(`time`, `title`, `timestamp`, `datetime`)VALUES(?, ?, ?, ?)";
            pst = connection.prepareStatement(sql);
            for (int i = 0; i < count; i++) {
                 String titleStr = title + i;
                 pst.setLong(1, time);
                 pst.setString(2, titleStr);
                 pst.setString(3, datetime);
                 pst.setTimestamp(4, timestamp);
                 pst.addBatch();
            }
            int[] executeNum = pst.executeBatch();
            System.out.println("batch: " + executeNum.length);

            // 提交
            connection.commit();
            System.out.println("commit=====");
            pst.close();
            connection.close();

        } catch (SQLException e) {
            try {
                // 回滚 必须进行 否则会导致数据库死锁
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void select() {
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            connection = DriverManager.getConnection(mysql_url, mysql_user, mysql_password);

            String sql = "SELECT * FROM `java` WHERE title LIKE ? ORDER BY id DESC LIMIT 5";
            pst = connection.prepareStatement(sql);
            pst.setString(1, "%insert%");
            rst = pst.executeQuery();

            while (rst.next()) {
                System.out.println("id: " + rst.getInt(1) + ", time: " + rst.getInt(2) + ", title: " + rst.getString(3)
                 + ", timestamp: " + rst.getString(4) + ", datetime: " + rst.getTimestamp(5));

                // timestamp返回会默认补上小数点，需要处理
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.y");
                String timestamp;
                try {
                    timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(df.parse(rst.getString(4)));
                    System.out.println("id:" + rst.getInt(1) + " time:" + rst.getInt(2) + " title:" + rst.getString(3)
                            + " timestamp:" + timestamp);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("=====");
            rst.close();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectRoll() {
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            // 可滚动的结果集
            connection = DriverManager.getConnection(mysql_url, mysql_user, mysql_password);

            String sql = "SELECT * FROM `java` WHERE title LIKE ? ORDER BY id DESC LIMIT 5";
            pst = connection.prepareStatement(sql);
            pst.setString(1, "%for%");
            rst = pst.executeQuery();
            while (rst.next()) {
                System.out.println("id:" + rst.getInt(1) + " time:" + rst.getInt(2) + " title:" + rst.getString(3)
                        + " timestamp:" + rst.getString(4) + " datetime:" + rst.getString(5));
            }
            System.out.println("=====");

            // 移动到第二行
            rst.absolute(2);
            System.out.println("id:" + rst.getInt(1) + " time:" + rst.getInt(2) + " title:" + rst.getString(3)
                    + " timestamp:" + rst.getString(4) + " datetime:" + rst.getString(5));
            System.out.println("=====");
            rst.close();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
