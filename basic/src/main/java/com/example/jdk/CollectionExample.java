package com.example.jdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @PackageName jdk
 * @Author joel
 * @Date 2018/12/21 14:32
 **/
public class CollectionExample {
    /**
     * 集合 长度可变；只能存储引用类型，可以存储多种引用类型
     * Collection
     * 		|--List
     * 		    |--ArrayList
     * 		    |--Vector
     * 			|--LinkedList
     * 		|--Set
     * 			|--HashSet
     * 			|--TreeSet
     */
    public static void collections() {
        // 给集合批量添加数据
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "hello", "world", "java");
        System.out.println(arrayList);
        System.out.println("---------------------------------------------");

        // 另一种方法
        List<String> lists = Arrays.asList("1", "2", "3");
        ArrayList<String> strings = new ArrayList<>(lists);
        System.out.println(strings);
        System.out.println("---------------------------------------------");

        // 交换
        Collections.swap(strings, 0, 2);
        System.out.println(strings);
        System.out.println("---------------------------------------------");

        // 翻转
        Collections.reverse(strings);
        System.out.println(strings);
        System.out.println("---------------------------------------------");

        // 排序
        Collections.sort(arrayList);
        System.out.println(arrayList);
        System.out.println("---------------------------------------------");

        // 二分查找，返回索引值
        int index = Collections.binarySearch(arrayList, "world");
        System.out.println(index);
        System.out.println("---------------------------------------------");

        // 替换
        boolean arrayList2 = Collections.replaceAll(arrayList, "java", "python");
        System.out.println(arrayList2);
        System.out.println(arrayList);
        System.out.println("---------------------------------------------");

        // shuffle方法 随机排序
        ArrayList<Integer> numbers = new ArrayList<>(100);
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }
        System.out.println(numbers);
        Collections.shuffle(numbers);
        /*
         返回一个以fromIndex为起始索引（包含），以toIndex为终止索引（不包含）的子列表（List）视图
         但值得注意的是，返回的这个子列表的幕后其实还是原列表
        */
        System.out.println(numbers);
        List<Integer> result = numbers.subList(0, 90);
        System.out.println(result);
        // 也就是说，修改这个子列表，将导致原列表也发生改变；反之亦然
        result.remove(88);
        System.out.println(result);
        System.out.println(numbers);


    }

    public static void main(String[] args) {
        collections();
    }
}
