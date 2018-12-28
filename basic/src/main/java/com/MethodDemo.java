package com;

import java.util.Scanner;

/**
 * @PackageName main
 * @Author joel
 * @Date 2018/12/11 16:28
 **/
public class MethodDemo {
    /**
     * 打印输出
     */
    public void printStar(){
        System.out.println("************************");
    }


    /**
     * 查找数组元素值方法
     */
    private boolean search(int n, int[] arr) {
        boolean tag = false;
        for (int anArr : arr) {
            if (n == anArr) {
                tag = true;
            }
        }
        return tag;
    }


    /**
     * 可变参数 必须放在方法参数中的最后一位
     * 且可变参数所在的列表是最后被访问的，
     * 假设有其他的重载方法，肯定先执行其他方法
     */
    public void sum(int... n) {
        int sum = 0;
        for (int as : n) {
            sum += as;
        }
        System.out.println("sum = " + sum);
    }


    /**
     * 返回数组最大值
     */
    public static int getMax(int[] arr) {
        int arrMax = arr[0];
        for (int anArr : arr) {
            if (arrMax < anArr) {
                arrMax = anArr;
            }
        }
        return arrMax;
    }

    public static void main(String[] args) {
        MethodDemo md = new MethodDemo();

        // 打印
        md.printStar();
        System.out.println("J         a         v         a");
        md.printStar();


        // 查找
        int[] arr = {10, 20, 30, 40, 50, 60};
        Scanner sc1 = new Scanner(System.in);
        System.out.println("请输入要查找的数据： ");
        int n1 = sc1.nextInt();
        boolean tag = md.search(n1, arr);
        if (tag) {
            System.out.println("找到");
        }else {
            System.out.println("没找到");
        }

        // 重载： 方法名相同，参数不同

        /* 一个方法可以修改 传递引用 所对应的 变量值，而不能修改 传递值 调用所对应的 变量值!
         *
         * 当传递方法参数类型为基本数据类型（数字以及布尔值）时，一个方法是不可能修改一个基本
         * 数据类型的参数
         */

         // 可变参数
        md.sum(1);
        md.sum(1, 2);
        md.sum(1, 2, 3);

        // 数组最大值
        int[] arr1 = {12, 86, 79, 43, 50};
        System.out.println(getMax(arr1));


    }

}
