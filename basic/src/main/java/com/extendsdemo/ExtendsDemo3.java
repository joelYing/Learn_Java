package com.extendsdemo;

/**
 * @PackageName main.ExtendsDemo
 * @Author joel
 * @Date 2018/12/13 16:43
 **/


class Person {
    private String name;
    private int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat() {
        System.out.println("吃饭");
    }

    public void sleep() {
        System.out.println("睡觉");
    }

    public void show() {
        System.out.println("show person");
    }
}


class Student extends Person {
    public Student() {

    }

    public Student(String name, int age) {
        super(name, age);
    }
    // 重写
    @Override
    public void show() {
        System.out.println("show student");
    }
}

class Teacher extends Person {

}

public class ExtendsDemo3 {
    public static void main(String[] args) {
        // Student
        Student s1 = new Student();
        s1.setName("李白");
        s1.setAge(21);

        System.out.println(s1.getName() + "---" + s1.getAge());
        s1.eat();
        s1.sleep();
        System.out.println("--------------------------------");

        Student s2 = new Student("太白", 21);
        System.out.println(s2.getName() + "---" + s2.getAge());
        s2.eat();
        s2.sleep();
        System.out.println("--------------------------------");

        // Teacher
        Teacher t = new Teacher();
        t.setName("洛阳");
        t.setAge(20);
        System.out.println(t.getName() + "---" + t.getAge());
        t.eat();
        t.sleep();
        System.out.println("--------------------------------");

        /* 相同名称的成员方法 先在子类中找，再在父类中找 */
        Student s3 = new Student();
        s3.show();

    }
}
