package com.example.jdk;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @PackageName jdk
 * @Author joel
 * @Date 2018/12/24 11:29
 **/
public class SetExample {
    /**
     * 1、List,Set都是继承自Collection接口，Map则不是
     *
     * 2、List特点：元素有放入顺序，元素可重复 ，
     *    Set特点：元素无放入顺序，元素不可重复，重复元素会覆盖掉，
     *
     *  （注意：元素虽然无放入顺序，但是元素在set中的位置是有该元素的HashCode决定的，
     *   其位置其实是固定的，加入Set 的Object必须定义equals()方法 
     *
     *   另外list支持for循环，也就是通过下标来遍历，也可以用迭代器
     *   但是set只能用迭代，因为他无序，无法用下标来取得想要的值
     *
     * 3、Set和List对比： 
     *  Set：检索元素效率低下，删除和插入效率高，插入和删除不会引起元素位置改变。 
     *  List：和数组类似，List可以动态增长，查找元素效率高，插入删除元素效率低，因为会引起其他元素位置改变。 
     * ---------------------
     */
    public static void hashset() {
        // Set 元素无序，不重复
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("D");
        hashSet.add("B");
        hashSet.add("C");
        hashSet.add("B");
        // 根据 hashCode值来决定该对象在HashSet中存储位置
        System.out.println(hashSet);

        // 迭代 遍历，但无法用下标
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("---");
        for (String s : hashSet) {
            System.out.println(s);
        }
        System.out.println("---");

        // 使用双向链表，保证插入和迭代的顺序 类似LinkHashMap 但是代价更高
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("C");
        linkedHashSet.add("A");
        linkedHashSet.add("B");
        System.out.println(linkedHashSet);
        System.out.println("---");

        // 有序集合, 元素唯一, 并按照要求排序
        // a:自然排序(元素具备比较性) 容器内是泛型的Object
        //	 让元素所属的类实现Comparable接口
        // b:比较器排序(集合具备比较性)
        //	 创建集合对象的时候，接受Comparator接口的实现类对象作为构造参数

        // 会进行自动排序
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("C");
        treeSet.add("A");
        treeSet.add("B");
        System.out.println(treeSet);

        System.out.println("============== hashset ==============");

    }

    public static void hashsetFunction() {
        HashSet<String> hashset = new HashSet<>();
        hashset.add("D");
        hashset.add("B");
        hashset.add("A");

        System.out.println(hashset);
        // 长度
        System.out.println(hashset.size());

        // 是否为空
        System.out.println(hashset.isEmpty());

        // 包含
        System.out.println(hashset.contains("D"));

        // 移除
        System.out.println(hashset.remove("A"));

        System.out.println(hashset);

        // 清除HashSet
        hashset.clear();
        System.out.println(hashset);
        System.out.println("============== hashset function ==============");
    }


    public static void main(String[] args) {
        hashset();
        hashsetFunction();
    }
}
