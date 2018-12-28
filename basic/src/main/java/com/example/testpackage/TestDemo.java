package com.example.testpackage;


/**
 * @PackageName main
 * @Author joel
 * @Date 2018/12/12 13:26
 **/

class TestDemo {
    // 私有构造方法
    /**
     * 私有构造方法
     */
    private TestDemo() {}

    /**
     * 遍历数组 格式是：[元素1， 元素2， ...]
     * @param arr 需要遍历的数组
     */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int a : arr) {
            if (a == arr[arr.length - 1]) {
                System.out.print(a);
            }else {
                System.out.print(a + "， ");
            }
        }
        System.out.println("]");
    }

    /**
     * 获取数组中的最大值
     * @param arr 包含最大值的数组
     * @return int 返回数组中最大值
     */
    public static int getMax(int[] arr) {
        int max = arr[0];

        for (int a : arr) {
            if (a > max) {
                max = a;
            }
        }

        return max;
    }
}

