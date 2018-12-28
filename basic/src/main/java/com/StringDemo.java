package com;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * @PackageName main
 * @Author joel
 * @Date 2018/12/7 13:39
 **/
public class StringDemo {
    public static void main(String[] args) {
//        test1();
//        test2();
//        str1();
//        empty();
        function();
        stringBufferDemo();
        stringBuilderDemo();
    }

    public static void test1() {
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
        System.out.println("-----------------------------------------");
    }

    public static void test2() {
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

        System.out.println("-----------------------------------------");
    }

    public static void str1() {
        // String 匿名对象 ，string1，string2都是对“name”的引用

        System.out.println("--------------------------");
        String string1 = "name";
        String string2 = "name";

        // String 对象 引用赋值

        String string3 = new String("name");
        String string4 = string3;

        System.out.println(string1 == string2);
        System.out.println(string1 == string3);
        System.out.println(string3 == string4);
        System.out.println(string1.equals(string3));
        System.out.println(string1.equalsIgnoreCase(string3));
        System.out.println("-----------------------------------------");
    }

    public static void empty() {
        String string5 = "abc";

        // 判断空 检查字符串长度可能有空指针异常，一般用 "".equals()
        boolean empty = string5.isEmpty();
        System.out.println(empty);

        String nullString = null;
        if (!"".equals(nullString)) {
//             // 条件通过但是任然报空指针错误 java.lang.NullPointerException
//            if (nullString.endsWith("c")) {
//                System.out.println(nullString);
//            }
        }

        // 更严谨的判断 StringUtils.equals(a,"") 好像有错
        if (StringUtils.isEmpty(nullString)) {
            System.out.println("这样可以");
        }

        System.out.println("-----------------------------------------");
    }

    public static void function() {
        String string1 = "hello";
        String string2 = "world";
        String string3 = "hello world!哈哈";

        // trim 去除字符串两端空格
        System.out.println("adsf".trim());

        // string1 > string2 为负值
        int compare = string1.compareTo(string2);
        System.out.println(compare);

        // 字符串连接
        String concat = string1.concat(string2);
        System.out.println(concat);

        // 前后缀匹配
        System.out.println(string1.startsWith("h"));
        System.out.println(string1.endsWith("d"));

        // 返回子串
        String substring = string1.substring(1, 3);
        System.out.println(substring);

        // 静态方法 返回字符串表示
        String valueof = String.valueOf(12138.12138);
        System.out.println(valueof);

        // 字符串查找
        int indexOf = string1.indexOf("ll");
        System.out.println(indexOf);

        // 包含
        boolean contain = string1.contains("ll");
        System.out.println(contain);

        // 字符串长度，中英文、标点、空格都是1
        int length1 = string1.length();
        int length2 = string3.length();
        System.out.println("length1: " + length1 + ", length2: " + length2);

        // 替换
        String replace = string1.replace("h", "b");
        System.out.println(replace);

        // 大小写转换
        System.out.println(string1.toUpperCase());

        System.out.println("-----------------------------------------");
    }

    public static void stringBufferDemo() {
        StringBuffer stringBuffer = new StringBuffer();

        // 字符串连接
        stringBuffer.append("hello");
        stringBuffer.append("WorLd");
        System.out.println(stringBuffer);

        // 任意位置插入
        stringBuffer.insert(1, "-insert-");
        System.out.println(stringBuffer);

        // 翻转字符串
        String reverse = stringBuffer.reverse().toString();
        System.out.println(reverse);

        System.out.println("-----------------------------------------");
    }

    public static void stringBuilderDemo() {
        // StringBuilder 功能与 StringBuffer 类似，StringBuilder用在字符串缓冲区被单个线程使用的时候，不支持多线程
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello");
        System.out.println(stringBuilder);

        System.out.println("-----------------------------------------");
    }

}
