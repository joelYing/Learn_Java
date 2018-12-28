package com.testpackage;

/**
 * @PackageName main.testpackage
 * @Author joel
 * @Date 2018/12/13 15:35
 **/
public class StaticDemo {
    /*
    *   局部代码块：在方法中出现；限定变量生命周期，及早释放，提高内存利用率
		构造代码块：在类中方法外出现；
					多个构造方法方法中相同的代码存放到一起，每次调用构造都执行，并且在构造方法前执行
		静态代码块：在类中方法外出现，加了static修饰。
					用于给类进行初始化，在加载的时候就执行，并且只执行一次。
    */

    static {
        System.out.println("AAAAA");
    }

    {
        System.out.println("BBBBB");
    }

    public StaticDemo() {
        {
            System.out.println("CCCCC");
        }
    }

    static {
        System.out.println("DDDDD");
    }

    {
        System.out.println("EEEEE");
    }
}
