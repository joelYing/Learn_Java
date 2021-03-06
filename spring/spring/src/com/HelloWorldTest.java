package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @PackageName com
 * @Author joel
 * @Date 2019/1/22 17:05
 **/
public class HelloWorldTest {
    public static void main(String[] args) {
        // 创建一个Spring的IOC容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从IOC容器中获取Bean实例
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld2");
        // 调用 sayHello() 方法
        helloWorld.sayHello();
    }
}
