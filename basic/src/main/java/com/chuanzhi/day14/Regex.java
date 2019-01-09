package com.chuanzhi.day14;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Github: https://github.com/DuGuQiuBai/Java
 *
 * @PackageName com.chuanzhi.day14
 * @Author joel
 * @Date 2019/1/8 16:13
 **/
public class Regex {
    /**
     * 正则验证 手机号
     */
    public static void phoneNumber() {
        /*
         * 13812345678, 13999998888
		 * 18912345678, 18811112222
         */
        String regex = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$";
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input your telephone number: ");
        String phone = sc.nextLine();

        boolean isPhoneNumber = phone.matches(regex);
        System.out.println(isPhoneNumber);
        System.out.println("------------------------------");
    }

    /**
     * 正则验证 邮箱
     */
    public static void email() {
        String emailRegex = "[\\w-\\.]+@([\\w-]+\\.)+[a-z]{2,3}";
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input your email: ");
        String phone = sc.nextLine();

        boolean isPhoneNumber = phone.matches(emailRegex);
        System.out.println(isPhoneNumber);
        System.out.println("------------------------------");
    }

    /**
     * 正则分割
     */
    public static void stringSplit() {
        String s5 = "D:\\develop\\eclipse-SDK-3.7.2-win64\\workspace\\day14_Regex";
        String regex5 = "\\\\";
        String[] strArray5 = s5.split(regex5);
        for (String aStrArray5 : strArray5) {
            System.out.println(aStrArray5);
        }
        System.out.println("------------------------------");
    }

    /**
     * 正则分割字符数组 重新排序 得到一个整形数组
     */
    public static void splitAndSort() {
        String s1 = "2 4 1 5 3";
        String[] strArr1 = s1.split(" ");
        // 把字符串数组转换成整数数组
        int[] arr1 = new int[strArr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(strArr1[i]);
        }
        Arrays.sort(arr1);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr1.length; i++) {
            if (i == arr1.length - 1) {
                result.append(arr1[i]);
            } else {
                result.append(arr1[i]).append(" ");
            }
        }
        System.out.println(result);
        System.out.println("------------------------------");
    }

    /**
     * 正则替换 数字 为 *
     */
    public static void replaceNumber() {
        String s = "hellowodekahaoshi62212934564347892nikyidaqiangeiwoxiexie1321";
        String ss = s.replaceAll("\\d+", "***");

        System.out.println(ss);
        System.out.println("------------------------------");
    }

    /**
     * 正则 Pattern Matcher 使用
     */
    public static void patternMatcher() {
        // Pattern Matcher的使用 取出长度为3的字符串
        String s6 = "adf kjdf sahd kjd ksj iwi ksjd ajsdkla kkk";
        String regex = "\\b[a-z]{3}\\b";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s6);

        // 取出匹配到的字符串
        while (m.find()) {
            System.out.println(m.group());
        }

        // 多行分组匹配
        String text = "<ul>\n" +
                "<li class=\"font1\">text1</li>\n" +
                "<li class=\"font2\">text2</li>\n" +
                "<li class=\"font3\">text3</li>\n" +
                "</ul>\n";
        System.out.println(text);
        String regex1 = "<li class=\"(.*?)\">(.*?)</li>";
        Pattern p1 = Pattern.compile(regex1);
        Matcher m1 = p1.matcher(text);

        // group() 是取到的每一组内容 group() 取值从1开始
        while (m1.find()) {
            System.out.println(m1.groupCount());
            // System.out.println(m1.group())
            System.out.println(m1.group(1));
            System.out.println(m1.group(2));
        }
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
//        phoneNumber();
//        email();
//        stringSplit();
//        splitAndSort();
//        replaceNumber();
        patternMatcher();
    }
}
