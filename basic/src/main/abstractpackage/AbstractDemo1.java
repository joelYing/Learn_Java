package main.abstractpackage;

/**
 * @PackageName main.abstractpackage
 * @Author joel
 * @Date 2018/12/14 14:11
 **/

/*
抽象类的特点：
		A:抽象类和抽象方法必须用abstract关键字修饰
		B:抽象类的子类
			a:要么是抽象类
			b:要么重写抽象类中的所有抽象方法
		C:抽象类不一定有抽象方法，有抽象方法的类一定是抽象类
		D:抽象类不能实例化
			那么如何使用抽象类的功能呢?
			按照多态的方式使用。抽象类多态。
 */

abstract class AbstractAnimal {
    /** 方法体内容为空的表现方式
     */
    public abstract void eat();
}

/**
抽象类的抽象子类
 */
abstract class AbstractDog extends AbstractAnimal {

}

/**
抽象类的子类 重写抽象类中的所有抽象方法
 */
class Cat extends AbstractAnimal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

public class AbstractDemo1 {
    public static void main(String[] args) {
        // 抽象类无法实例化
        // AbstractAnimal aa = new AbstractAnimal();

        Cat c = new Cat();
        c.eat();

        // 多态
        AbstractAnimal a = new Cat();
        a.eat();
    }
}
