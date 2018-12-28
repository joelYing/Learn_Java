package com.jdk;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * @PackageName jdk
 * @Author joel
 * @Date 2018/12/25 11:08
 **/
public class FormatExample {
    /**
     * 数字格式化：
     * 可以使用NumberFormat类进行本地化数字显示
     * 可以使用DecimalFormat指定格式化模板
     */
    public static void numberFormat() {
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println(nf.format(123456789));
        System.out.println(nf.format(1234567.89));

        try {
            long l = (long)nf.parse("123,456,789");
            System.out.println(l);

            double d = (double)nf.parse("1,234,567.89");
            System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("===== numberformat =====");
    }

    public static void decimalFormat() {
        System.out.println(new DecimalFormat("###,###.###").format(123456789.23456));
    }

    public static void main(String[] args) {
        numberFormat();
        decimalFormat();
    }
}
