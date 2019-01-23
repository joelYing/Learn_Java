package com;

/**
 * @PackageName com
 * @Author joel
 * @Date 2019/1/22 17:03
 **/
public class HelloWorld {
    private String name;

    public HelloWorld() {
        System.out.println("这是无参构造函数");
    }

    public HelloWorld(String name) {
        this.name = name;
        System.out.println("使用了Spring的构造方法 ： " + name);
    }

    public HelloWorld(String name, HelloWorld helloWorld) {
        this.name = name;
        System.out.println("使用了注入对象引用 ： " + name  + " , 引用了单个参数的构造函数 ： " + helloWorld.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello " + name);
    }
}
