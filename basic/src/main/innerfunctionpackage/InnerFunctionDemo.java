package main.innerfunctionpackage;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

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

    public static void random() {
        
    }

    public static void main(String[] args) throws ParseException {
        biginteger();
        bigdecimal();
        date();
        dateformat();
        calender();
        random();
    }

}


