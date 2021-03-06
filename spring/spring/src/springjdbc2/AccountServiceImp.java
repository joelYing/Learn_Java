package springjdbc2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @PackageName springjdbc2
 * @Author joel
 * @Date 2019/1/28 12:17
 **/
@Transactional
public class AccountServiceImp implements AccountService{
    @Autowired
    private AccountDao accountDao;

    @Override
    public void pay(String out, String in, double money) {
        // 扣钱
        accountDao.outMoney(out, money);
        // 加钱
        accountDao.inMoney(in, money);
    }
}
