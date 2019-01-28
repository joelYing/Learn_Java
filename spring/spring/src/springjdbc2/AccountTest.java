package springjdbc2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @PackageName springjdbc2
 * @Author joel
 * @Date 2019/1/28 12:51
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springJDBC2.xml")
public class AccountTest {
    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    @Test
    public void run3() {
        accountService.pay("joel", "mm", 100);
    }
}
