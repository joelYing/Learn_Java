package com;

/**
 * @PackageName com
 * @Author joel
 * @Date 2019/1/24 10:54
 **/
public class Demo2 {
    public Demo2() {

    }

    private void turnOn() {
        System.out.println("初始化Bean");
    }

    private void turnOff() {
        System.out.println("销毁Bean");
    }

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
