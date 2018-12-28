package com.extendsdemo;

/**
 * @PackageName main.ExtendsDemo
 * @Author joel
 * @Date 2018/12/13 15:54
 **/

class Fu {
//    private int num = 100;
//    public int num2 = 200;
//
//    public int getNum() {
//        return num;
//    }
//
//    public void setNum(int num) {
//        this.num = num;
//    }
//
//    private void show() {
//        System.out.println("show");
//    }
//
//    public void show2() {
//        System.out.println("show2");
//    }

    public Fu() {
        System.out.println("父类无参构造方法");
    }

    public Fu(String name) {
        System.out.println("hello");
    }

}

class Zi extends Fu {
    public Zi() {
        /* 这样的形式在构造方法中只能出现一次 */
        /* 子类中所有的构造方法默认都会访问父类中空参数的构造方法 */
//        super();
//        super("lao wang");
        System.out.println("zi()");
    }

    public Zi(String name) {
        super(name);
        System.out.println("world");
    }
}

public class ExtendsDemo1 {
    public static void main(String[] args) {
        Zi zi = new Zi();

        /* 每一个构造方法的第一条语句默认都是：super()
        子类只能继承父类所有非私有的成员(成员方法和成员变量) */
//        System.out.println(zi.num2);
//        zi.show2();
//
//        Fu fu = new Fu();
//        System.out.println(fu.getNum());

        System.out.println("--------------------------------------");
        Zi zi2 = new Zi("Java");
    }
}
