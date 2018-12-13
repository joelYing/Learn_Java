package main.classdemodictionary;

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

    public static void setAge(int a) {
        age = a;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
