package springjdbc2;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
/**
 * @PackageName springjdbc2
 * @Author joel
 * @Date 2019/1/28 12:20
 **/
public class AccountDaoImp extends JdbcDaoSupport implements AccountDao{
    /**
     * 通过扩展 JdbcDaoSupport，设置数据源
     */
    @Override
    public void outMoney(String out, double money) {
        this.getJdbcTemplate().update("update t_account set money = money - ? where name = ?", money, out);
    }

    @Override
    public void inMoney(String in, double money) {
        this.getJdbcTemplate().update("update t_account set money = money + ? where name = ?", money, in);
    }
}
