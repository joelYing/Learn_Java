package springjdbc;

import org.junit.runner.RunWith;
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
}
