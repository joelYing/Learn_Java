package com.example.jdk;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @PackageName jdk
 * @Author joel
 * @Date 2018/12/24 16:09
 **/
public class DateExample {
    /**
     * 应该使用 Calendar 类实现日期和时间字段之间转换
     * 用 DateFormat 类来格式化和解析日期字符串
     */
    public static void date() {
        // 毫秒时间戳
        Date date = new Date();
        long time = date.getTime();
        System.out.println(date);
        System.out.println(time);
        System.out.println("-----");
        Calendar calendar = new GregorianCalendar();
        // 2018
        System.out.println(calendar.get(Calendar.YEAR));

        DateFormat df1 = DateFormat.getInstance();
        DateFormat df2 = DateFormat.getDateInstance();
        DateFormat df3 = DateFormat.getDateTimeInstance();

        // 2018/12/24 下午4:51
        System.out.println(df1.format(date));
        // 2018年12月24日
        System.out.println(df2.format(date));
        // 2018年12月24日 下午4:51:28
        System.out.println(df3.format(date));
        System.out.println("-----");
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.YEAR_FIELD, new Locale("zh", "CN"));
        DateFormat df5 = DateFormat.getDateTimeInstance(DateFormat.YEAR_FIELD, DateFormat.ERA_FIELD, new Locale("zh", "CN"));
        System.out.println(df4.format(date));
        System.out.println(df5.format(date));

        System.out.println("===== date =====");
    }

    public static void timezone() {
        // 时区
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(timeZone);

        SimpleDateFormat zoneFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        zoneFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        System.out.println(zoneFormat.format(new Date()));

        zoneFormat.setTimeZone(TimeZone.getTimeZone("GMT-8"));
        System.out.println(zoneFormat.format(new Date()));

        System.out.println("===== timezone =====");
    }

    public static void simpleDateFormat() {
        // SimpleDateFormat 是 DateFormat 的子类，提供自由的格式化
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));

        // 自定义解析、格式化
        String strDateTime = "2011-11-11 11:11:11.111";
        String input = "yyyy-MM-dd HH:mm:ss.sss";
        String output = "yyyy年MM月dd日 HH时mm分ss秒";

        SimpleDateFormat sdf1 = new SimpleDateFormat(input);
        SimpleDateFormat sdf2 = new SimpleDateFormat(output);
        Date d = null;
        try {
            d = sdf1.parse(strDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(sdf2.format(d));

        // 字符串转时间戳
        String dateTimeString = "2011-11-11 11:11:11.111";
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
        try {
            Date date1 = sdf3.parse(dateTimeString);
            // 返回自1970年1月1日00:00:00 GMT已经过去了多少毫秒
            long timestamp = date1.getTime();
            System.out.println(timestamp/1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 时间戳转字符串
        long timestamp = 1476843636;
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp * 1000));

        // 凌晨00:00:00的时间戳
        long zerotime = 0;
        try {
            Date today = new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            zerotime = today.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(zerotime);

        System.out.println("===== simpleDateFormat =====");
    }

    public static void function() {
        Date date = new Date();
        // 获取昨日、上月、去年
        Calendar now = GregorianCalendar.getInstance();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(now.getTime()));

        Calendar today = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
        today.add(Calendar.DATE, -1);
        Date yesterday = today.getTime();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(yesterday));

        today.add(Calendar.MONTH, -1);
        Date lastMonth = today.getTime();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(lastMonth));

        today.add(Calendar.YEAR, -1);
        Date lastYear = today.getTime();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(lastYear));
        System.out.println("===== function =====");
    }

    public static void main(String[] args) {
//        date();
//        timezone();
//        simpleDateFormat();
        function();
    }
}
