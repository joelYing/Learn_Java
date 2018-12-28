package com.example.apache;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @PackageName com.apache
 * @Author joel
 * @Date 2018/12/28 15:27
 **/
public class CommonsLang {
    /**
     * Apache Commons Lang 是对 java.lang 的扩充，并且很多Util弥补了默认JDK对null的不足
     */
    public static void arrayUtil() {
        // ArrayUtils 扩展了一些方法
        int[] array = {2, 3, 4, 5};
        // 元素索引值
        System.out.println(ArrayUtils.indexOf(array, 3));
        // 转换成字符串
        System.out.println(ArrayUtils.toString(array));
        // 包含
        System.out.println(ArrayUtils.contains(array, 4));
        // 是否为空
        System.out.println(ArrayUtils.isNotEmpty(array));

        array = ArrayUtils.add(array, 6);
        System.out.println(ArrayUtils.toString(array));
        // 截取 startindex < array <= endindex ；第一位索引为1
        System.out.println(ArrayUtils.toString(ArrayUtils.subarray(array, 1, 4)));

        System.out.println("===== ArrayUtils =====");
    }

    public static void stringUtil() {
        String s1 = "  HelloWorld  ";

        // isEmpty 判断了 null 和空字符串
        System.out.println(StringUtils.isEmpty(""));
        // isBlank 判断了 null 、空字符串 、以及含有空格的空字符串
        System.out.println(StringUtils.isBlank(""));

        // String.trim() 会有空指针异常 StringUtils.trim() 则可以返回 null
        String nullString = null;
        System.out.println(StringUtils.trim(nullString));
        // strip() 具有自定义trim()列表的功能
        System.out.println(StringUtils.strip(s1, " Hd"));

        // 数组连接 null被当成空字符串
        String[] s2 = {null, "a", "b"};
        System.out.println(StringUtils.join(s2, ','));

        // split对null会返回null 对分隔符null当成空格
        String s3 = "a,b,c";
        System.out.println(ArrayUtils.toString(StringUtils.split(s3, ",")));

        // 替换
        System.out.println(StringUtils.replace(s3, "a", "c"));

        // 填充
        System.out.println(StringUtils.leftPad(s3, 10, "0"));

        // 首字母大写
        System.out.println(StringUtils.capitalize(s3));

        // 前缀后缀检查 注意null，null为true
        String s4 = "p_abc_s";
        System.out.println(StringUtils.startsWith(s4, "p_"));
        System.out.println(StringUtils.endsWith(s4, "_s"));

        // 翻转
        System.out.println(StringUtils.reverse(s4));

        // 字符串截取
        System.out.println(StringUtils.substring(s4, 0, 3));

        // 字符串查找
        System.out.println(StringUtils.indexOf(s4, "ab"));

        // 判断是否为数字
        System.out.println(StringUtils.isNumeric("123456789"));
        System.out.println(StringUtils.isNumeric("123a"));

        System.out.println("===== StringUtils =====");
    }

    public static void numberUtil() {
        // 检查字符串是否是只包含数字字符，Null和空将会返回false
        System.out.println(NumberUtils.isDigits("12345"));
        System.out.println(NumberUtils.isDigits("a12345"));

        // 非数字与null会转换为0 解决 parseInt 异常
        System.out.println(NumberUtils.toInt("12345"));
        System.out.println(NumberUtils.toInt("a12345"));
        System.out.println(NumberUtils.toInt("-12345"));
        System.out.println(NumberUtils.toInt(null));

        System.out.println(Integer.parseInt("123"));
        // 异常
//        System.out.println(Integer.parseInt("a123"))
//        System.out.println(Integer.parseInt(null))

        System.out.println("===== numberUtil =====");
    }

    public static void randomUtil() {
        for (int i = 0; i < 10; i++) {
            // 返回指定区域内的整数，最小值必须非负，包括下线但不包括上限
            System.out.println(RandomUtils.nextInt(0, 9));
        }
        // 生成一个随机字符串 --> count 长度 ； letters 生成的字符串可以包括字母 ； numbers 可以包括数字
        System.out.println(RandomStringUtils.random(32, true, true));
        // 字符将从字符串指定的字符集中选择，不能为空。如果NULL，则使用所有字符集
        System.out.println(RandomStringUtils.random(32, "abcdefghijklmnopqrstyuvwxyz"));
        // 奇怪的所有字符集
        System.out.println(RandomStringUtils.random(32));
    }

    public static void main(String[] args) {
        arrayUtil();
        stringUtil();
        numberUtil();
        randomUtil();
    }
}
