package com.chuanzhi.day20;

/**
 * @PackageName com.chuanzhi.day20
 * @Author joel
 * @Date 2019/1/9 12:05
 **/
public class DiGui {
    /**
     * 实现阶乘
     */
    public static int jc(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n*jc(n-1);
        }
    }

    public static void main(String[] args) {
        // 循环实现
        int jc = 1;
        for (int i = 1; i <= 5; i++) {
            jc *= i;
        }
        System.out.println("5的阶乘： " + jc);

        // 递归实现
        System.out.println("5的阶乘： " + jc(5));
    }
}
