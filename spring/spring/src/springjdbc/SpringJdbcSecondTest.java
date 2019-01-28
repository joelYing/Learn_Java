package springjdbc;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @PackageName springjdbc
 * @Author joel
 * @Date 2019/1/25 18:33
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springJDBC.xml")
public class SpringJdbcTest2 {
    @Resource(name="jdbcTemplate")
    public JdbcTemplate jdbcTemplate;

    public void run2() {
        jdbcTemplate.update("insert into t_account values(null,?,?)","2019",1000);
    }
}
