package com.extendsdemo;

/**
 * @PackageName main.extendsdemo
 * @Author joel
 * @Date 2018/12/14 10:47
 **/

/* 特点：
		类：类被final修饰，说明该类是最终类，不能被继承。
		成员变量：变量被final修饰后，就变成了常量。值不能被 修改 。
		成员方法：方法不能被子类重写。 */

// final class Fu5 {

//class Fu5 {
//    public int num1 = 20;
//    public final int num2 = 40;
//
//    public final void getResource() {
//        System.out.println("秘密");
//    }
//
//    public void show() {
//        num1 = 100;
//        System.out.println(num1);
//        // num2 = 200;
//        System.out.println(num2);
//    }
//}
//
//class Zi5 extends Fu5 {
////    public void getResource() {
////
////    }
//}
//
//public class ExtendsDemo5 {
//    public static void main(String[] args) {
//        Zi5 zi5 = new Zi5();
//        System.out.println(zi5.num1);
//        System.out.println(zi5.num2);
//        zi5.getResource();
//        zi5.show();
//    }
//}

/*
	final修饰局部变量
		基本类型：基本类型的值不能变量
		引用类型：引用类型的地址值不能改变
*/

class Person5 {
    public void show() {
        //局部变量
        int num  = 10;
        System.out.println(num);
        num = 100;
        System.out.println(num);

        //final修饰局部变量
        final int num2 = 20;
        System.out.println(num2);
//        num2 = 200;
        System.out.println(num2);
    }

    public void method() {
        //局部变量
        Student5 s1 = new Student5();
        System.out.println(s1.age);
        s1.age = 100;
        System.out.println(s1.age);

        //s1 = new Student();

        //final修饰局部变量
        final Student5 s2 = new Student5();
        System.out.println(s2.age);
        s2.age = 100;
        System.out.println(s2.age);

        //s2 = new Student();
    }
}

class Student5 {
    int age = 10;
}

class ExtendsDemo5 {
    public static void main(String[] args) {
        Person5 p = new Person5();
        p.show();
//        p.method();
    }
}