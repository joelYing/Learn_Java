package com.algorithm;

import java.util.Arrays;

/**
 * @PackageName algorithm
 * @Author joel
 * @Date 2018/12/27 16:26
 **/
public class SortExample {
    public static int[] data = {23, 69, 44, 12, 87, 56, 33, 90, 72};

    /**
     * 插入排序
     *
     * 第一个元素可以被认为是已经排序的
     * 从下一个元素开始，从后往前与前面的元素比较，若小于前面的元素则插入
     */
    public static void insertsort() {
        int[] list = new int[data.length];
        System.arraycopy(data, 0, list, 0, data.length);

        int temp;
        for (int i = 1; i < list.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if (list[j + 1] < list[j]) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
                System.out.println(Arrays.toString(list));
            }
            System.out.println(i + " -_- ");
        }
        System.out.println(Arrays.toString(list));
        System.out.println("===== insert sort =====");
    }

    /**
     * 选择排序
     *
     * 在未排序序列中找到最小（大）元素，存放到未排序序列的起始位置
     * 它的排序结果也还是不稳定的。 唯一值得高兴的是，它并不耗费额外的内存空间
     */
    public static void selectsort() {
        int[] list = new int[data.length];
        System.arraycopy(data, 0, list, 0, data.length);

        int temp;
        for (int i = 0; i < list.length; i++) {
            int min = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[min]) {
                    min = j;
                }
            }
            // 交换
            temp = list[min];
            list[min] = list[i];
            list[i] = temp;
            System.out.println(Arrays.toString(list));
        }
        System.out.println("===== select sort =====");
    }

    /**
     * 冒泡排序
     *
     * 通过交换相邻值，每次排出最小的
     * 通过设置flag，该轮无交换，提前结束循环
     */
    public static void bubblesort() {
        int[] list = new int[data.length];
        System.arraycopy(data, 0, list, 0, data.length);

        System.out.println("第0次: ");
        for (int p : list){
            System.out.print(p + " ");
        }

        for (int i = 0; i < list.length - 1; i++) {
            boolean tag = false;
            for (int j = 0; j < list.length - 1; j++) {
                if (list[j] > list[j+1]) {
                    int tmp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = tmp;
                    tag = true;
                }
            }
            if (!tag) {
                break;
            }
            System.out.println(" \n第" + (i + 1) +"次:  ");
            for (int p : list){
                System.out.print(p + " ");
            }
        }
        System.out.println("\n===== bubble sort =====");
    }

    public static void main(String[] args) {
//        insertsort();
//        selectsort();
        bubblesort();
    }
}
