package main.classdemopackage;

/**
 * @PackageName main.ClassDemoDictionary
 * @Author joel
 * @Date 2018/12/13 10:08
 **/
class Student {
    /*private修饰的成员只能在本类中才能访问，外部类要访问可以通过方法  及成员变量私有化 对外提供set 、get方法*/

    String sid;
    private String name;
    /* static 类成员 无论多少个对象都共用一个值
    *  访问方式： 类.类成员 对象.类成员*/

    private static int age;

    /**
    *无参构造方法
    */
    public Student() {
        System.out.println("我是学生");
    }

    public void study() {
        System.out.println("我要学习");
    }

    public void eat() {
        System.out.println("我要吃饭");
    }

    public void sleep() {
        System.out.println("我要睡觉");
    }

    /* 因为静态是随着类的加载而加载，优先于对象而存在。而this是随着对象的创建而存在 */

    public static void setAge(int a) {
        age = a;
    }

    public int getAge() {
        return age;
    }

    // 非静态成员方法可以访问静态成员方法 ， 静态只能访问静态

    public void setName(String name) {
        setAge(18);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
