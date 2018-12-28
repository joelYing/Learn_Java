package com.jdk;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @PackageName jdk
 * @Author joel
 * @Date 2018/12/25 9:51
 **/
public class Date8Example {
    /**
     * JDK8中新增对事件的操作
     */
    public static void date() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDate localDate = now.toLocalDate();
        LocalTime localTime = now.toLocalTime();
        String times = localDate + " " + localTime;
        System.out.println(times);

        System.out.println("===== date =====");
    }

    public static void format() {
        LocalDateTime now = LocalDateTime.now();
        LocalDate localDate = now.toLocalDate();

        // 格式化与解析
        String ymd1 = localDate.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
        String ymd2 = now.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒"));
        System.out.println(ymd1);
        System.out.println(ymd2);

        // 字符串解析
        String st = "2018年12月25日 10时09分59秒";
        LocalDateTime pdt = LocalDateTime.parse(st, DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒"));
        System.out.println(pdt);
        System.out.println(pdt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // ISO标准格式可直接解析
        String date1 = "2018-12-25";
        LocalDate parse1 = LocalDate.parse(date1);
        System.out.println(parse1);
        String date2 = "2018-12-25T10:12:59";
        LocalDateTime parse2 = LocalDateTime.parse(date2);
        System.out.println(parse2);
        System.out.println("=====");

        // 获取时间戳，毫秒
        long timestamp1 = Clock.systemDefaultZone().millis();
        long timestamp2 = System.currentTimeMillis();
        // 获取时间戳 秒
        long timestamp3 = Instant.now().getEpochSecond();
        System.out.println(timestamp1);
        System.out.println(timestamp2);
        System.out.println(timestamp3);

        // 字符串与时间戳相互转换
        long timestamp4 = 1491582600;
        String format = "yyyy-MM-dd HH:mm:ss";
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(timestamp4, 0,ZoneOffset.UTC);
        String timeString = localDateTime.format(DateTimeFormatter.ofPattern(format));
        System.out.println(timeString);

        LocalDateTime localDateTime1 = LocalDateTime.parse(timeString, DateTimeFormatter.ofPattern(format));
        long timestamp5 = localDateTime1.toInstant(ZoneOffset.UTC).getEpochSecond();
        System.out.println(timestamp5);

        System.out.println("===== format =====");
    }

    public static void function() {
        LocalDateTime now = LocalDateTime.now();
        LocalDate localDate = now.toLocalDate();

        // 日期时间操作
        System.out.println(localDate);
        System.out.println(now.plusDays(3));
        System.out.println(now.minusDays(3));
        System.out.println(now.with(TemporalAdjusters.lastDayOfYear()));
        System.out.println("===== function =====");
    }

    public static void main(String[] args) {
        date();
        format();
        function();
    }
}
