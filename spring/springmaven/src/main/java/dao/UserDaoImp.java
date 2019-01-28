package dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @PackageName dao
 * @Author joel
 * @Date 2019/1/28 16:47
 **/
public class UserDaoImp extends JdbcDaoSupport implements UserDao {
    @Override
    public void save(String username, String password) {
        this.getJdbcTemplate().update("insert into user(id,username,password) values(?,?,?)",null,username,password);
    }
}
