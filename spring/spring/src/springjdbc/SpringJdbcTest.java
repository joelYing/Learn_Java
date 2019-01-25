package springjdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @PackageName springjdbc
 * @Author joel
 * @Date 2019/1/25 16:22
 **/
public class SpringJdbcTest {
    /**
     * 相对原始的方法
     */
    private static void run1() {
        // 使用Spring内置的连接池
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        // jdbc:mysql:/// 等价于 jdbc:mysql://localhost:3306
        // The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized or represents 时区问题
        dataSource.setUrl("jdbc:mysql:///springjdbc?serverTimezone=GMT%2B8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        // 创建模板类
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // 数据添加
        jdbcTemplate.update("insert into t_account values (14,?,?)", "Spring", 998.0);
    }


    private static void run2() {

    }

    public static void main(String[] args) {
        run1();
    }
}
