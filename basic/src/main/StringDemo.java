package main;

import java.util.Scanner;

/**
 * @PackageName main
 * @Author joel
 * @Date 2018/12/7 13:39
 **/
public class StringDemo {
    public static void main(String[] args) {
        // public String() 创建String对象
        String s1 = "";
        System.out.println("s1:" + s1);
        System.out.println("s1.length():" + s1.length());
        System.out.println("--------------------------");

        // 字节数组转换成字符串
        byte[] bytes = {97, 98, 99, 100, 101};
        System.out.println(bytes.length);
        String s2 = new String(bytes);
        System.out.println("s2:" + s2);
        System.out.println("s2.length():" + s2.length());
        System.out.println("--------------------------");

        // 字节数组中的一部分转换成字符串
        String s3 = new String(bytes, 0, bytes.length - 1);
        System.out.println("s3:" + s3);
        System.out.println("s3.length():" + s3.length());
        System.out.println("--------------------------");

        // 字符数组转字符串
        char[] ch1 = {'a', 'b', 'c'};
        String s4 = new String(ch1);
        System.out.println("s4:" + s4);
        System.out.println("s4.length():" + s4.length());
        System.out.println("--------------------------");

        // 字符数组一部分转字符串
        String s5 = new String(ch1, 1, 2);
        System.out.println("s5:" + s5);
        System.out.println("s5.length():" + s5.length());
        System.out.println("--------------------------");

        // 字符串是常量
        String s6 = "a";
        s6 += "s";
        System.out.println(s6);

        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个字符串：");
        String s = sc.nextLine();
        
        int bigCount = 0, smallCount = 0, numberCount = 0;
        
        for (int x = 0; x < s.length(); x++) {
            char ch = s.charAt(x);
            
            if (ch >= 'A' && ch <= 'Z') {
                bigCount++;
            }else if (ch >= 'a' && ch <= 'z') {
                smallCount++;
            }else if ( ch >= '0' && ch <= '9') {
                numberCount++;
            }
        }

        System.out.println("大写： " + bigCount);
        System.out.println("小写： " + smallCount);
        System.out.println("数字： " + numberCount);

    }
}
