package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @PackageName com
 * @Author joel
 * @Date 2019/1/23 16:25
 **/
public class DemoTest {
    private static void run1(){
        // 加载 Spring 上下文
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Demo1 demo1 = (Demo1) ac.getBean("demo1");
        System.out.println(demo1);
    }

    private static void run2() {
        // 加载 Spring 上下文应用
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Demo2 demo2 = (Demo2) ac.getBean("demo2");
        System.out.println(demo2);
        // 手动销毁 Bean
        ((ClassPathXmlApplicationContext) ac).close();
    }

    public static void run3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Demo3 demo3 = (Demo3) ac.getBean("demo3");
        for (Object object : demo3.getChildMap().values()) {
            System.out.println(object);
        }
    }

    public static void main(String[] args) {
//        run2();
        run3();
    }
}
