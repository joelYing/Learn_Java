package interfacepackage;

/**
 * @PackageName main.interfacepackage
 * @Author joel
 * @Date 2018/12/14 15:45
 **/

/*
接口的特点：
		A:接口用关键字interface表示
			格式：interface 接口名 {}
		B:类实现接口用implements表示
			格式：class 类名 implements 接口名 {}
		C:接口不能实例化
			接口多态。
		D:接口的子类
			a:要么是抽象类
			b:要么重写接口中的所有的抽象方法
 */

interface Animal {
    int num1 = 10;
    /** 默认修饰符 public static final
     */
    public static final int nums = 30;

    public abstract void show();
}

abstract class AbstractDog implements Animal {

}

class Cat implements Animal {
    @Override
    public void show() {
        System.out.println("cat");
    }
}

public class InterfaceDemo1 {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.show();
        System.out.println(Animal.nums);
        System.out.println(Animal.num1);
    }
}
