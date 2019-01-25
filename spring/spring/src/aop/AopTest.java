package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @PackageName aop
 * @Author joel
 * @Date 2019/1/24 16:17
 **/
public class AopTest {
    private static void run1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("springaop.xml");
        Fruits fruits = (Fruits) ac.getBean("apple");
        fruits.price();
    }

    public static void main(String[] args) {
        run1();
    }
}
