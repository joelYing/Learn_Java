package main.classdemodictionary;

/**
 * @PackageName main
 * @Author joel
 * @Date 2018/12/13 10:07
 **/
public class ClassDemo {
    public static void main(String[] args) {
        Student student = new Student();
        Student student1 = new Student();

        student.study();
        student.eat();
        student.sleep();

        System.out.println(student.getAge());
        System.out.println(student.getName());

        // 给私有成员变量赋值
        Student.setAge(18);
        student.setName("李白");

        Student.setAge(20);
        student1.setName("杜甫");
        System.out.println(student.getName() + " : " +student.getAge() + "岁");
        System.out.println(student1.getName() + " : " +student1.getAge() + "岁");

    }
}
