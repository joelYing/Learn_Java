package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @PackageName com
 * @Author joel
 * @Date 2019/1/23 16:25
 **/
public class DemoTest {

    public static void run(){
        // 加载 Spring 上下文
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Demo1 demo1 = (Demo1) ac.getBean("demo1");
//        System.out.println(demo1);
    }

    public static void main(String[] args) {
        run();
    }
}
