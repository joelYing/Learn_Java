package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
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

        insert(5);
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
