package annotationaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @PackageName annotationaop
 * @Author joel
 * @Date 2019/1/25 15:15
 **/
public class AnnotationTest {
    public static void run1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("springannotation.xml");
        Melon melon = (Melon) ac.getBean("melon");
        melon.changePrice();
    }

    public static void main(String[] args) {
        run1();
    }
}
