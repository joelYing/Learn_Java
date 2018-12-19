package polymorphismpackage;

/**
 * @PackageName main.polymorphismpackage
 * @Author joel
 * @Date 2018/12/14 11:16
 **/
//
//class Animal {
//    public int age = 40;
//
//    public void show() {
//        System.out.println("show animal");
//    }
//
//    public static void eat() {
//        System.out.println("eat");
//    }
//}
//
//class Dog extends Animal {
//    public int age = 20;
//
//    @Override
//    public void show() {
//        System.out.println("show dog");
//    }
//    public static void eat() {
//        System.out.println("dog eat meat");
//    }
//}
//
//public class DuoTaiDemo1 {
//    public static void main(String[] args) {
//        // 也就是说 多态访问成员变量时 结果看左边；访问成员方法时 结果看右边；访问静态方法 看左边
//        Animal a = new Dog();
//
//        System.out.println(a.age);
//        a.show();
//        Animal.eat();
//
//        System.out.println(((Dog) a).age);
//        Animal.eat();
//    }
//}


/** 调用a.show() 时因为new的是B，所以会去B类中找show()方法，B中本身没有show()
 *  但是B继承了A中的show() 所以调用的就是A中的show()方法，而A中show()方法调用的是show2()
 *  因为B中 重写了show2()方法，所以就执行B中的show2()
 */
class A{
    public void show(){
        show2();
    }
    public void show2(){
        System.out.println("1");
    }
}
class B extends A {
    @Override
    public void show2(){
        System.out.println("2");
    }

}
class C extends B {
    @Override
    public void show(){
        super.show();
    }

    @Override
    public void show2(){
        System.out.println("3");
    }

    public void show3() {
        System.out.println("4");
    }
}

class DuoTaiDemo1 {
    public static void main(String[] args) {
        A aa = new A();
        aa.show2();
        A a = new B();
        a.show();
        B b = new C();
        b.show();
        // 没有向下转型前不可调用C中特有的方法
        // b.show3();
    }
}

