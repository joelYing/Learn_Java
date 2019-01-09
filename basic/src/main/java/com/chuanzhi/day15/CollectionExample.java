package com.chuanzhi.day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @PackageName com.chuanzhi.day15
 * @Author joel
 * @Date 2019/1/9 10:26
 **/
public class CollectionExample {
    public static void collection1() {
        ArrayList<String> arrayList = new ArrayList<>();
        // 添加
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        arrayList.add(2, "two");

        arrayList.set(3, "three");
        System.out.println(arrayList);

        Collections.addAll(arrayList, "1", "2", "3");
        System.out.println(arrayList);

        // 遍历
        for (String string : arrayList) {
            System.out.println(string);
        }

        // 迭代器迭代
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String string = it.next();
            System.out.println(string);
        }
    }

    public static void deduplication() {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "1", "2", "2", "2", "3", "1", "3");
//        for (int i = 0; i < arrayList.size() - 1; i++) {
//            for (int j = 1; j < arrayList.size() - 1; j++) {
//                if (arrayList.get(i).equals(arrayList.get(j))) {
//                    arrayList.remove(j)
//                }
//            }
//        }
//        System.out.println(arrayList)
//        System.out.println("--")
        // 利用 HashSet 无序不重复的特性
        HashSet<String> h = new HashSet<>(arrayList);
        arrayList.clear();
        arrayList.addAll(h);
        System.out.println(arrayList);
        System.out.println("--");
    }

    public static void main(String[] args) {
//        collection1();
        deduplication();
    }
}
