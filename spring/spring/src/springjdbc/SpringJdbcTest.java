package springjdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @PackageName springjdbc
 * @Author joel
 * @Date 2019/1/25 16:22
 **/
public class SpringJdbcTest {
    public static void run1() {
        // 使用Spring内置的连接池
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        // jdbc:mysql:/// 等价于 jdbc:mysql://localhost:3306
        dataSource.setUrl("jdbc:mysql:///springjdbc");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        // 创建模板类
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // 数据添加
        jdbcTemplate.update("insert into t_account values (null,?,?)", "Spring", 998);
    }

    public static void main(String[] args) {
        run1();
    }
}
