package com.jdk;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @PackageName jdk
 * @Author joel
 * @Date 2018/12/24 14:01
 **/
public class MapExample {

    /**
     * Hash表的实现，最好能预估容量
     * 默认Hash桶是16，当数量达到桶数量75%时，hash冲突比较严重，会成倍扩容，并重新分配所有原来的数据
     * 当产生hash冲突时，JDK是使用链表法，JDK8新增一个为默认8的阈值，当超过阈值转换成红黑树
     * HashMap数据是乱序的
     */
    public static void hashmap() {
        // 由键值组成，键唯一，值可重复
        // HashMap 为新的操作类， HashTable是旧的操作类，HashTable性能低但线程安全
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.put("key3", "value3");
        hashMap.put("key4", "value4");
        System.out.println(hashMap);

        // 遍历所有的key
        Set<String> keys = hashMap.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
        System.out.println("---");

        // 遍历所有的value
        Collection<String> values = hashMap.values();
        for (String value : values) {
            System.out.println(value);
        }
        System.out.println("---");

        // 遍历所有的key和value
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("========== hashmap ==========");
    }

    public static void hashmapFunction() {
        // 初始化容量
        HashMap<String, String> hashMap = new HashMap<>(100);
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.put("key3", "value3");
        hashMap.put("key4", "value3");
        System.out.println(hashMap);

        // 取出键 key2 的值
        if (hashMap.containsKey("key2")) {
            System.out.println(hashMap.get("key2"));
        }

        // 判断是否空
        System.out.println(hashMap.isEmpty());

        // 长度
        System.out.println(hashMap.size());

        // 移除
        hashMap.remove("key3");
        System.out.println(hashMap);
        System.out.println("========== hashmap function ==========");
    }

    /**
     * 红黑树实现，平衡二叉树
     * 插入，删除代价大
     */
    public static void treemap() {
        // 有序Map 基于红黑树自动实现排序的Map 提供一些比较方法
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("k1", "v1");
        treeMap.put("k2", "v2");
        treeMap.put("k3", "v3");
        treeMap.put("a1", "v4");
        treeMap.put("a2", "v5");
        treeMap.put("a3", "v6");
        System.out.println(treeMap);

        // 遍历所有键与值
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // 键值小于 a2 的集合 (a2 之前的键值对)
        SortedMap<String, String> aMap = treeMap.headMap("a2");
        System.out.println(aMap);

        // a2 包括 a2之后的键值对
        SortedMap<String, String> bMap = treeMap.tailMap("a2");
        System.out.println(bMap);

        // a2 与 k2之间包括 a2 的键值对
        SortedMap<String, String> cMap = treeMap.subMap("a2", "k2");
        System.out.println(cMap);

        System.out.println("========== treemap ==========");

        SortedMap<String, Integer> sortedTreeMap = new TreeMap<>();
        sortedTreeMap.put("aa", 11);
        sortedTreeMap.put("bb", 22);
        sortedTreeMap.put("cc", 33);
        sortedTreeMap.put("dd", 44);
        sortedTreeMap.put("ee", 55);
        // 长度
        System.out.println(sortedTreeMap.size());
        // 所有键值对
        System.out.println(sortedTreeMap.entrySet());
        // 第一个key元素
        System.out.println(sortedTreeMap.firstKey());
        // 最后一个key元素
        System.out.println(sortedTreeMap.lastKey());
        // cc 之前的元素
        System.out.println(sortedTreeMap.headMap("cc"));
        // cc 及之后的元素
        System.out.println(sortedTreeMap.tailMap("cc"));
        // aa 到 dd 之间包括 aa 的元素
        System.out.println(sortedTreeMap.subMap("aa", "dd"));
        // 所有的values
        System.out.println(sortedTreeMap.values());

        System.out.println("========== sortedtreemap ==========");
    }

    public static void linkedHashMap() {
        // LinkedHashMap 维护了一个双链表 定义了迭代顺序 及插入顺序
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("a2", "v2");
        hashMap.put("k1", "v1");
        hashMap.put("k3", "v3");
        hashMap.put("k4", "v4");

        System.out.println(hashMap);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey());
        }

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(hashMap);
        System.out.println(linkedHashMap);
        System.out.println("========== linkedHashMap ==========");
    }

    /**
     * 线程安全的 HashMap
     * JDK8 之前，默认16把写锁，有效分散阻塞的概率，即锁分段技术，
     * JDK8 之后，改为精心设计的，只在需要加锁的时候加锁
     */
    public static void concurrentHashmap() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("concurrent1", "value1");
        concurrentHashMap.put("concurrent2", "value2");
        concurrentHashMap.put("concurrent3", "value3");
        concurrentHashMap.put("concurrent4", "value4");
        System.out.println(concurrentHashMap);

        System.out.println("========== concurrentHashMap ==========");
    }

    public static void main(String[] args) {
//        hashmap();
//        hashmapFunction();
//        treemap();
//        linkedHashMap();
        concurrentHashmap();
    }
}
