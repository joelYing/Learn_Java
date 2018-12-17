package main;

/**
 * @PackageName main
 * @Author joel
 * @Date 2018/12/17 12:25
 **/
//class Student1 {
//    private String name;
//    private int age;
//
//    public Student1() {
//        super();
//    }
//
//    public Student1(String name, int age) {
//        super();
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//}
//
//public class ObjectDemo {
//    public static void main(String[] args) {
//        Student1 s1 = new Student1();
//
//        // 调用内部的toString()
//        System.out.println(s1);
//        System.out.println("--------------------");
//
//        System.out.println(s1.getClass().getName());
//        System.out.println("--------------------");
//
//        System.out.println(s1.hashCode());
//        System.out.println("--------------------");
//
//        System.out.println(Integer.toHexString(s1.hashCode()));
//
//    }
//}

class Student implements Cloneable {
    private String name;
    private int age;

    public Student() {
        super();
    }

    public Student(String name, int age) {
        super();
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ObjectDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student("林青霞", 28);

        Object obj = s1.clone();
        Student s2 = (Student) obj;

        System.out.println(s1.getName() + "---" + s1.getAge());
        System.out.println(s2.getName() + "---" + s2.getAge());

        Student s3 = s1;
        System.out.println(s3.getName() + "---" + s3.getAge());
        System.out.println("--------------------------------");

        s1.setName("张曼玉");

        System.out.println(s1.getName() + "---" + s1.getAge());
        System.out.println(s2.getName() + "---" + s2.getAge());
        System.out.println(s3.getName() + "---" + s3.getAge());
    }
}

