package com.example.testpackage;

import java.util.Random;

/**
 * @PackageName main.testpackage
 * @Author joel
 * @Date 2018/12/13 13:03
 **/
public class TestTest {
    public static void main(String[] args) {
        int[] arr = {56,38,91,72,40};

        TestDemo.printArray(arr);
        System.out.println(TestDemo.getMax(arr));

        Random random = new Random();
        System.out.println(random.nextInt(100));

        StaticDemo sd = new StaticDemo();

    }
}
