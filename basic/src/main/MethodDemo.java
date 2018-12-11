package main;

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
    }

}
