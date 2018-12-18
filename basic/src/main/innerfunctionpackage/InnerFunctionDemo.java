package main.innerfunctionpackage;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @PackageName main.innerfunctionpackage
 * @Author joel
 * @Date 2018/12/18 11:04
 **/
public class InnerFunctionDemo {
    public static void biginteger() {
        // 大整数计算
//        Integer i = 1213800012138;
        BigInteger bi = new BigInteger("1213800012138");
        System.out.println(bi);

        BigInteger bi1 = new BigInteger("10");
        BigInteger bi2 = new BigInteger("20");

        System.out.println("add: " + bi1.add(bi2));
        System.out.println("sub: " + bi1.subtract(bi2));
        System.out.println("mul: " + bi1.multiply(bi2));
        System.out.println("divi: " + bi2.divide(bi1));
        // 得到整数和余数 20/10 得2 余0
        BigInteger[] bis = bi2.divideAndRemainder(bi1);
        for (BigInteger s : bis) {
            System.out.println(s);
        }

        System.out.println("-----------------------------");
    }

    public static void bigdecimal() {
        System.out.println(0.09 + 0.01);
        System.out.println(1.0 - 0.32);
        System.out.println(1.015 * 100);
        System.out.println(1.301 / 100);

        BigDecimal bd1 = new BigDecimal("0.09");
        BigDecimal bd2 = new BigDecimal("0.01");
        System.out.println("add: " + bd1.add(bd2));

        BigDecimal bd3 = new BigDecimal("1.0");
        BigDecimal bd4 = new BigDecimal("0.32");
        System.out.println("sub: " + bd3.subtract(bd4));

        BigDecimal bd5 = new BigDecimal("1.015");
        BigDecimal bd6 = new BigDecimal("100");
        System.out.println("mul: " + bd5.multiply(bd6));

        BigDecimal bd7 = new BigDecimal("1.301");
        BigDecimal bd8 = new BigDecimal("100");
        // BigDecimal.divide 要求这个结果保留有scale个小数位，roundingMode表示的就是保留模式是什么
        System.out.println("divi: " + bd7.divide(bd8, 3, RoundingMode.CEILING));
        System.out.println("divi: " + bd7.divide(bd8, 4, RoundingMode.CEILING));

        System.out.println("-----------------------------");
    }

    public static void date() {
        // Date 表示特定的瞬间，精确到毫秒
        Date d = new Date();
        System.out.println("d: " + d);

        // 当前时间毫秒值,转换为日期
        long time = System.currentTimeMillis();
        Date d2 = new Date(time);
        System.out.println("d2: " + d2);

        Date d3 = new Date(3600000);
        System.out.println("d3: " + d3);


        Date d4 = new Date();
        System.out.println("d4: " + d4);
        d4.setTime(3600000);
        System.out.println("d4: " + d4);

        System.out.println("-----------------------------");
    }

    public static void dateformat() throws ParseException {
        /*
         * 针对日期进行格式化和解析的抽象类
         * SimpleDateForamt：
         * 格式化（日期 -> 文本）
         *      Date	--	String
         * 解析（文本 -> 日期）
         * 		String 	-- 	Date
         */
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        String result = sdf.format(d);
        System.out.println(result);

        String s = "2008-08-08 12:23:34";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d2 = sdf2.parse(s);
        System.out.println(d2);

        System.out.println("-----------------------------");

    }

    public static void calender() {
        // Calendar:把时间分割成了一个个的年，月，日，时，分，秒等
        // 创建对象
        Calendar rightNow = Calendar.getInstance();

        // year
        int year = rightNow.get(Calendar.YEAR);
        System.out.println(year);
        // month
        int month = rightNow.get(Calendar.MONTH);
        System.out.println(month);
        // date
        int date = rightNow.get(Calendar.DATE);
        System.out.println(date);
        // hour
        int hour = rightNow.get(Calendar.HOUR);
        System.out.println(hour);
        // minute
        int minute = rightNow.get(Calendar.MINUTE);
        System.out.println(minute);
        // second
        int second = rightNow.get(Calendar.SECOND);
        System.out.println(second);

        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR) + "---"
                + (c.get(Calendar.MONTH) + 1) + "---" + c.get(Calendar.DATE));
        c.add(Calendar.YEAR, -3);
        c.add(Calendar.MONTH, 2);
        c.add(Calendar.DATE, -12);
        System.out.println(c.get(Calendar.YEAR) + "---"
                + (c.get(Calendar.MONTH) + 1) + "---" + c.get(Calendar.DATE));

        // 重写给c对象赋值
        c.set(2012, 3, 4);
        System.out.println(c.get(Calendar.YEAR) + "---"
                + (c.get(Calendar.MONTH) + 1) + "---" + c.get(Calendar.DATE));

        Calendar c1 = Calendar.getInstance();

        // 设置年月日
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要获取哪一年的2月份：");
        int syear = sc.nextInt();
        // 任意一年的3月1日
        c1.set(syear, 2, 1);
        // 任意一年的2月最后一天
        c1.add(Calendar.DATE, -1);

        System.out.println(c1.get(Calendar.DATE));

        System.out.println("-----------------------------");
    }

    public static void random() throws NoSuchAlgorithmException {
        // Math.random() 是java.util.Random 线程安全
        for (int i = 0; i < 10; i++) {
            System.out.println(Math.random());
        }
        System.out.println("--");

        // 不含参的构造函数每次都使用当前时间作为种子，随机性更强
        long seed = System.currentTimeMillis();
        // 而含参的构造函数其实是伪随机，其随机结果固定，更有可预见性
//        Random r2 = new Random(seed);
        Random r1 = new Random(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(r1.nextInt(1000));
        }
        System.out.println("--");

        // 提供加密的强随机数生成器 (RNG)，要求种子必须是不可预知的，产生非确定性输出，可用特定算法初始化
        SecureRandom sr1 = new SecureRandom();
        for (int i = 0; i < 10; i++) {
            System.out.println(sr1.nextInt(1000));
        }
        System.out.println("--");

//        SecureRandom sr2 = SecureRandom.getInstance("SHA1PRNG");
//        for (int i = 0; i < 10; i++) {
//            System.out.println(sr2.nextInt(1000));
//        }
//        System.out.println("--");

        // 捕捉异常
        SecureRandom sr3 = null;
        try {
            sr3 = SecureRandom.getInstance("SHA1PRNG");
            for (int i = 0; i < 10; i++) {
                System.out.println(sr3.nextInt(1000));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("--");

        System.out.println("-----------------------------");
    }

    public static void systemdemo() {
        // System 类包含一些有用的类字段和方法。它不能被实例化
        // public static void gc():运行垃圾回收器。
        // public static void exit(int status):终止当前正在运行的 Java 虚拟机。参数用作状态码；根据惯例，非 0 的状态码表示异常终止
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            System.out.print(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时： " + (end - start) + "毫秒");

        int[] arr = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 6, 7, 8, 9, 10 };
        // 数组1，数组1的复制起始位置， 数组2， 数组2的粘贴起始位置， 复制的长度
        System.arraycopy(arr, 1, arr2, 2, 3);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));

        System.out.println("-----------------------------");
    }

    public static void re() {
        // 校验QQ号
        Scanner s = new Scanner(System.in);
        System.out.println("输入一个QQ号： ");
        String qq = s.nextLine();
        if (qq.matches("[1-9][0-9]{4,14}")) {
            System.out.println("QQ号正确");
        }else {
            System.out.println("QQ号不正确");
        }

        // String 类的分割功能
        String s1 = "aa,.  \\bb,.  \\cc,.  \\";
        String[] strArray1 = s1.split(",");
        String[] strArray2 = s1.split("\\.");
        String[] strArray3 = s1.split(" ");
        String[] strArray4 = s1.split(" +");
        String[] strArray5 = s1.split("\\\\");

        for (int i = 0; i < strArray5.length; i++) {
            String s2 = strArray5[i];
            System.out.println(s2);
        }

        // 转换字符串 "2 3 5 1 4" -> "1 2 3 4 5"
        String s3 = "2 3 5 1 4";
        String[] sa = s3.split(" ");
        int[] arr = new int[sa.length];
        for (int i = 0; i < sa.length; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int anArr : arr) {
            sb.append(anArr);
            sb.append(" ");
        }
        String result = sb.toString();
        String s4 = result.trim();
        System.out.println(s4);

        // 正则替换 替换 数字 为 ***
        String s5 = s4.replaceAll("\\d+", "***");
        System.out.println(s5);

        // Pattern Matcher的使用
        String s6 = "adf kjdf sahd kjd ksj iwi ksjd ajsdkla kkk";
        String regex = "\\b[a-z]{3}\\b";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s6);
        // 取出匹配到的字符串
        while (m.find()) {
            System.out.println(m.group());
        }

        System.out.println("-----------------------------");
    }

    public static void main(String[] args) throws ParseException, NoSuchAlgorithmException {
//        biginteger();
//        bigdecimal();
//        date();
//        dateformat();
//        calender();
//        random();
//        systemdemo();
        re();
    }

}


