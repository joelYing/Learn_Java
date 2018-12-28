package com.example.polymorphismpackage;

/**
 * @PackageName main.polymorphismpackage
 * @Author joel
 * @Date 2018/12/14 13:13
 **/

class Animal {
    public void eat() {
        System.out.println("吃");
    }
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
    public void help() {
        System.out.println("导盲");
    }
}

class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("抓老鼠");
    }
}

public class DuoTaiDemo2 {
    public static void main(String[] args) {
        // 向上转型
        Animal a = new Dog();
        a.eat();
        // 不可调用Dog类中独有的方法 向下转型后可以
        // a.help();

        // 向下转型
        Dog d = (Dog)a;
        d.eat();
        d.help();
        System.out.println("-----------------");

        a = new Cat();
        a.eat();

        Cat c = (Cat)a;
        c.eat();

//        Dog dd = (Dog)a;
//        dd.eat();
//        dd.help();
    }
}
