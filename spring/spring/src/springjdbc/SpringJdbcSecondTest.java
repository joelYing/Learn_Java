package springjdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @PackageName springjdbc
 * @Author joel
 * @Date 2019/1/25 18:33
 **/

// 使用Spring框架管理模板类

@RunWith(SpringJUnit4ClassRunner.class)  // 获取测试类对象
@ContextConfiguration("classpath:springJDBC.xml")  // 加载配置文件

public class SpringJdbcSecondTest {
    // @Resource默认按照名称方式进行bean匹配
    // @Autowired默认按照类型方式进行bean匹配，通常与@Qualifier搭配使用
    // @Resource(import javax.annotation.Resource)是J2EE的注解
    // @Autowired( import org.springframework.beans.factory.annotation.Autowired)是Spring的注解

    @Autowired
    @Qualifier("jdbcTemplate")
    public JdbcTemplate jdbcTemplate;

    @Test
    public void run2() {
        jdbcTemplate.update("insert into t_account values(2,?,?)","mm",1000);
    }
}
