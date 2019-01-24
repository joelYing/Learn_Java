package autowringbean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @PackageName autowringbean
 * @Author joel
 * @Date 2019/1/24 14:17
 **/
public class EmpService {
    // 注入Dao，存在与 bean id="empDao" 相同的属性 empDao，且存在 setter 方法
    // 标注在私有属性上也可以，会注入，但不会执行 setter 方法

    @Autowired
    private EmpDao empDao;
    // @Autowired 标注在 setter 方法上可以完成注入

    public void setEmpDao(EmpDao empDao) {
        System.out.println("EmpService --> EmpDao");
        this.empDao = empDao;
    }

    public void play() {
        empDao.play();
    }

//    private UserDao userDao;
//
//    public void setUserDao(UserDao userDao) {
//        System.out.println("EmpService --> UserDao");
//        this.userDao = userDao;
//    }
}
