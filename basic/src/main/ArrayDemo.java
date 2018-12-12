package main;

import java.util.*;


/**
 * @PackageName main
 * @Author joel
 * @Date 2018/12/7 17:43
 **/
public class ArrayDemo {

    /**
     * 加密方法
     */
    private static void jiaMi(int number) {
        int[] arr = new int[8];

        // 倒序，每位数字加5再%10
        String snumber = number + "";
        System.out.println(snumber);
        int[] numArr = new int[snumber.length()];
        for (int i = 0; i < snumber.length(); i++) {
            numArr[snumber.length()-i-1] = (Integer.parseInt(snumber.charAt(i)+"", 10) + 5)%10;
        }

        // 交换最后一位与第一位
        int tmp = numArr[0];
        numArr[0] = numArr[numArr.length-1];
        numArr[numArr.length-1] = tmp;

        for (int na : numArr) {
            System.out.print(na);
        }
        System.out.println();
    }

    public static void main(String[] args){
        // 声明并创建整形数组 默认值0
        int[] intArray = new int[6];

        // 字符型数组
        char[] chArray = new char[6];
        char[] chArray2 = {'1', '2', '3'};

        // 浮点型数组 默认值 0.0
        float[] floatArray;

        // 字符串数组 默认值null
        String[] sArray;

        System.out.println(chArray[0] + " " + chArray[1]);


        // 二维数组
        int[][] arr2 = {{22,66,44},{77,33,88},{25,45,65},{11,66,99}};
        int sum2 = 0;

        for (int[] x : arr2) {
            for (int y : x) {
                sum2 += y;
            }
        }

        System.out.println("sum2=" + sum2);

        // 加密
        Scanner sj = new Scanner(System.in);
        System.out.println("请输入小于8位的整数");
        int number = sj.nextInt();
        jiaMi(number);

        // 从键盘接收输入数组并输出
        int[] k = new int[5];
        Scanner sc1 = new Scanner(System.in);
        for (int i=0; i<k.length;i++) {
            System.out.println("输入第" + (i + 1) + "个数： ");
            k[i] = sc1.nextInt();
        }
        System.out.println("数组k内容为：");

        // foreach 循环输出
        for (int aK : k) {
            System.out.print(" " + aK + " ");
        }

        // 冒泡排序(优化)
        System.out.println("\n-------------------------------------");
        int[] mp = {34, 53, 12, 32, 56, 17};
        System.out.println("\n第0次: ");
        for (int p : mp){
            System.out.print(p + " ");
        }

        for (int j=0; j<mp.length - 1; j++) {
            boolean tag = false;
            for (int i=0; i<mp.length - 1; i++) {
                if (mp[i] > mp[i+1]) {
                    int tmp = mp[i];
                    mp[i] = mp[i+1];
                    mp[i+1] = tmp;
                    tag = true;
                }
            }
            if (!tag) {
                break;
            }
            System.out.println(" \n第" + (j + 1) +"次:  ");
            for (int p : mp){
                System.out.print(p + " ");
            }
        }
        System.out.println("\n-------------------------------------");



    }
}
