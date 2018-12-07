package main;

import java.util.Scanner;
import java.lang.*;

public class BasicDemo {
    public static void main(String[] args) {
        // byte 1个字节
        byte b;

        // short 2个字节
        short sh;

        // int 4个字节
        int i;

        // long 8个字节
        long l;

        // 键盘输入
        /*System.out.println("请输入一个String： ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(str);*/

        // float 4个字节 数据类型需要在末尾加上 f/F
        float f = 123.456F;
        // double 8个字节 类型范围大于float
        double d = 123.456;

        double d1 = 123;
        double d2 = 124f;

        // println 换行输出
        // System.out.print() 不换行输出
        System.out.println("f = " + f);
        System.out.println("d = " + d);
        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);

        // 字符型，2个字节 大于65535就需要强制类型转换
        char ch = 'a';
        char ch3 = 97;
        char ch2 = (char) 65536;
        char ch1 = '\\';

        System.out.println("ch = " + ch);
        System.out.println("ch1 = " + ch1);
        System.out.println("ch2 = " + ch2);
        System.out.println("ch3 = " + ch3);

        // Unicode
        char c = '\u005d';
        System.out.println("c = " + c);

        // 布尔类型 1个字节
        boolean bl = true;
        System.out.println("bl = " + bl);

        /*
        char 中文 = '中';
        System.out.println(中文);*/

        // 科学计数法表示浮点类型
        double d3 = 1.23E3;
        float f2 = 1.23e5f;
        double d4 = .5;
        System.out.println("d3 = " + d3 +" f2 = " + f2 + " d4 = " + d4);

        // 常量 final 定义 不可修改 常量名大写
        final double PI = 3.1415;

        // 自动转换
        short a = 168;
        int ba = a;
        System.out.println("ba = " + ba);

        /* 包装类
        作为和基本数据类型对应的类类型存在,方便涉及到对象的操作.
        包含每种基本数据类型的相关属性如最大值、最小值等,以及相关的操作方法.
        */
        int imax = Integer.MAX_VALUE;
        long lmax = Long.MAX_VALUE;
        char cm = Character.MAX_VALUE;
        int isize = Integer.SIZE;

        System.out.println("imax: " + imax);
        System.out.println("lmax: " + lmax);
        System.out.println("cm: " + cm);
        System.out.println("isize: " + isize);

        // 强制类型转换 10/3 = 3 ; (float)10/3 = 3.3333333
        System.out.println((float)10/3);

        // 整数转字符串 用 ’整数 + ""‘的方式比整数类的toString()快

        // 其它数据类型转十进制 注意输入的字符串中不需要再加表示进制的前缀，如16进制不要加"0x"
        // parseInt(String) 将string转换为整数；valueOf(String) 将string转换为Integer对象
        System.out.println("------------------------------------");
        int ei = Integer.valueOf("10110", 2);
        int ei2 = Integer.parseInt("073", 8);
        int si = Integer.parseInt("3c", 16);

        System.out.println("ei = " + ei + " ei2 = " + ei2 + " si = " + si);
        System.out.println("------------------------------------");

        // 任何数据类型向String转换
        String test = "test";
        int x = 30;
        System.out.println(x + test);

        // char 数组到 String 相互转换
        char data[] = {'1', '2', '3'};
        String s = new String(data);
        System.out.println(s);
        final char[] cs = s.toCharArray();
        System.out.println(cs.length);

        // 字符串转整型 但是两者类型不同
        int is = Integer.parseInt("1234");
        System.out.println(is);
        Integer integer = Integer.valueOf("1234");
        System.out.println(integer);

        // bytes 数组与 String 相互转换
        String bs1 = "bytes";
        byte[] bytes = bs1.getBytes();
        System.out.println(bytes);

        // 查看返回的bytes数组中的值
        for (byte by : bytes) {
            System.out.println(by);
        }

        String bs2 = new String(bytes);
        System.out.println(bs2);
    }
}
