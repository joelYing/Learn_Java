package service;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @PackageName service
 * @Author joel
 * @Date 2019/1/28 16:45
 **/

@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public void save(String username, String password) {
        userDao.save(username, password);
    }
}
