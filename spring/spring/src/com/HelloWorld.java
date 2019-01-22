package com;

/**
 * @PackageName com
 * @Author joel
 * @Date 2019/1/22 17:03
 **/
public class HelloWorld {
    private String name;

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
