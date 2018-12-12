package main;


/**
 * @PackageName main
 * @Author joel
 * @Date 2018/12/12 13:26
 **/
public class TestDemo {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 10;

        System.out.println(compare(a, b));
        System.out.println(compare(10, 10));
    }

    public static boolean compare(byte a, byte b) {
        System.out.println("long");
        return a == b;
    }

    public static boolean compare(int a, int b) {
        System.out.println("long");
        return a == b;
    }

//    public static boolean compare(lang a, lang b) {
//        System.out.println("long");
//        return a == b;
//    }
}
