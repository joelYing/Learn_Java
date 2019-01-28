package springjdbc2;

/**
 * @PackageName springjdbc2
 * @Author joel
 * @Date 2019/1/28 12:16
 **/
public interface AccountDao {
    void outMoney(String out, double money);

    void inMoney(String in, double money);
}
