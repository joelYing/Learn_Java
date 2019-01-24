package autowringbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @PackageName autowringbean
 * @Author joel
 * @Date 2019/1/24 14:21
 **/
public class Test {
    public static void run1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        ac.getBean("empService");
    }

    public static void run2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        EmpService es = (EmpService) ac.getBean("empService");
        es.play();
    }

    public static void main(String[] args) {
        run2();
    }
}
