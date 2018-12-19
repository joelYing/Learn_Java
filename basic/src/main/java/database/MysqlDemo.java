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
    private static String userDir = System.getProperties().getProperty("user.dir");
    private static String DS = File.separator;
    private static String mysql_driver = null;
    private static String mysql_url = null;
    private static String mysql_user = null;
    private static String mysql_password = null;

    public static void main(String[] args) {
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
            PreparedStatement pst = null;
            String sql = "INSERT INTO `java`(`time`,`title`,`timestamp`,`datetime`) VALUES (?, ?, ?, ?)";
            pst = connection.prepareStatement(sql);
            for (int i = 0; i < count; i++) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
