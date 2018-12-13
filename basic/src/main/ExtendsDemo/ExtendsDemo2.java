package main.ExtendsDemo;

/**
 * @PackageName main.ExtendsDemo
 * @Author joel
 * @Date 2018/12/13 16:13
 **/

//class Father {
//    public int age = 40;
//}
//
//class Son extends Father {
//    public int num = 100;
//    public int age = 20;
//
//    public void show() {
//        int age = 60;
//        System.out.println(age);
//        // 使用本类的成员变量
//        System.out.println(this.age);
//        // super 使用父类的成员变量
//        System.out.println(super.age);
//        System.out.println(num);
//    }
//}
//
//public class ExtendsDemo2 {
//    public static void main(String[] args) {
//        Son son = new Son();
//        son.show();
//    }
//}
//System.out.println("--------------------------------------------")


//class FuQing {
//    static {
//        System.out.println("静态代码块Fu");
//    }
//
//    {
//        System.out.println("构造代码块Fu");
//    }
//
//    public FuQing() {
//        System.out.println("构造方法Fu");
//    }
//}
//
//class EZi extends FuQing {
//    static {
//        System.out.println("静态代码块Zi");
//    }
//
//    {
//        System.out.println("构造代码块Zi");
//    }
//
//    public EZi() {
//        System.out.println("构造方法Zi");
//    }
//}
//
//class ExtendsDemo2 {
//    public static void main(String[] args) {
//        EZi eZi1 = new EZi();
//        EZi eZi2 = new EZi();
//    }
//}
//System.out.println("--------------------------------------------")

class X {
    Y b = new Y();
    X() {
        System.out.print("X");
    }
}

class Y {
    Y() {
        System.out.print("Y");
    }
}

public class ExtendsDemo2 extends X {
    Y y = new Y();
    ExtendsDemo2() {
        //super();//默认，供系统底层检查调用，而不具体执行class Z的构造方法
        System.out.print("Z");
    }

    public static void main(String[] args) {
        new ExtendsDemo2();
    }
}
