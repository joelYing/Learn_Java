package main;

import java.util.*;


/**
 * @PackageName main
 * @Author joel
 * @Date 2018/12/7 17:43
 **/
public class ArrayDemo {
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
