package com.extendsdemo;

/**
 * @PackageName main.extendsdemo
 * @Author joel
 * @Date 2018/12/14 10:31
 **/

class Animal {
    private String name;
    private int age;

    public Animal() {

    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show() {
        System.out.println(name + "---" + age);
    }
}

class Cat extends Animal {
    public Cat() {

    }

    public Cat(String name, int age) {
        super(name, age);
    }

    public void catchMouse() {
        System.out.println("猫捉老鼠");
    }
}

class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    public void lookDoor() {
        System.out.println("看门狗");
    }
}

public class ExtendsDemo4 {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.setName("加菲猫");
        c.setAge(2);
        c.show();
        c.catchMouse();
        System.out.println("---------------");
        Cat c1 = new Cat("Tom", 1);
        c1.show();
        c1.catchMouse();
        System.out.println("---------------");

        Dog d1 = new Dog();
        d1.setName("牧羊");
        d1.setAge(3);
        d1.show();
        d1.lookDoor();
        System.out.println("---------------");
        Dog d2 = new Dog("狮子", 6);
        d2.show();
        d2.lookDoor();


    }
}
