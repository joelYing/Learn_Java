package com.jdk;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.SynchronousQueue;

/**
 * @PackageName jdk
 * @Author joel
 * @Date 2018/12/21 15:35
 **/
public class ListExample {
    /**
     * ArrayList 以数组实现，最好能预估容量 ensureCapacity() 方法
     * 数组有容量限制，默认是10，超出限制扩容50%，扩容操作是 System.arraycopy 复制到新数组
     * 按照索引 get,set 性能很高
     * 按照索引 add,remove 性能不高，因为需要复制移动数组，越靠前需要移动的数组越多
     * contains、indexOf、remove 需要遍历
     */
    public static void arrayList() {
        // 实现 List 接口提供的 add、 get、 indexOf、 remove、 set 等方法
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add(1, "insert");
        stringList.set(2, "set");
        System.out.println(stringList);
        System.out.println(stringList.get(2));
        System.out.println(stringList.indexOf("insert"));
        System.out.println(stringList.remove(1));
        System.out.println(stringList);
        System.out.println("--------------------------");

        // 遍历
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }
        for (String string : stringList) {
            System.out.println(string);
        }

        stringList.add("Demo");
        System.out.println(stringList);

        // 迭代器 定义为了接口，由具体的集合类通过内部类的方式提供实现
        // 本身有两个方法 1、hasNext() 2、next()

        // 移除集合中特定的字符串
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            if ("set".equals(string)) {
                iterator.remove();
            }
        }
        // stringList.removeIf(string -> string.equals("set"));
        // stringList.removeIf("set"::equals);

        System.out.println(stringList);
        System.out.println("-------------------------");

        // toArray方法可以将集合变为数组，但是类集声明时已经通过泛型制定了集合的类型。所以
        // 接收时要使用泛型制定的类型
        Object[] objAry = stringList.toArray();
        for (int i = 0; i < objAry.length; i++) {
            System.out.println((String)objAry[i]);
        }
        //                                   初始化一个String类型的数组
        String[] strAry  = stringList.toArray(new String[] {});
        for (int i = 0; i < strAry.length; i++) {
            System.out.println(strAry[i]);
        }
        System.out.println("-------------------------");

        // Vector 是 List 的前身 ，性能低但线程安全
        Vector<String> vector = new Vector<>();
        vector.add("1");
        vector.add("2");
        vector.add("3");
        System.out.println(vector);

        System.out.println("============= ArrayList ============");
    }

    /**
     * 双向链表，无容量限制，占用了更多的空间
     * 按照索引 get、set，需要移动链表指针
     * 插入、删除，操作不需要复制移动数据，但是也要移动链表指针。在链表两头的操作能减少指针的移动
     * Apache Commons 有个 TreeNodeList 可以快速移动到位
     * contains、indexOf、remove 需要遍历
     *
     * 双向列表既是List，也是Queue
     */
    public static void linkedList() {
        // 实现List 与 Queue接口 所以必须直接使用LinkedList类
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("first");
        linkedList.add("second");
        linkedList.add("third");
        System.out.println(linkedList);

        // 头尾增加元素
        linkedList.addFirst("head");
        linkedList.addLast("last");
        System.out.println(linkedList);

        // 获取头尾元素
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        // 移除头尾元素
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);

        // 获取头部元素 如果空链表则返回 null ，getFirst()会异常
        System.out.println(linkedList.peek());
        // 获取并移除头部元素
        System.out.println(linkedList.poll());

        System.out.println(linkedList);
        System.out.println("============= LinkedList ============");
    }

    public static void stackList() {
        Stack<String> stack = new Stack<>();
        // 入栈
        stack.push("first");
        stack.push("second");
        stack.push("third");
        System.out.println(stack + ": " + stack.size());

        // 出栈
        int size = stack.size();
        // 这里需要取栈的长度作为一个定值，若 i < stack.size() 则会导致每次循环由于出栈都会导致站长度的变化，最后就只能输出两个
        for (int i = 0; i < size; i++) {
            System.out.println(i + " : " +stack.pop());
        }
        System.out.println("---");
        System.out.println("============= StackList ============");
    }

    public static void arrayListFunction() {
        // 将一个元素添加到已经完整的ArrayList中，那么它会在内部自动重新调整大小以适应新元素
        // 当需要向已经完整的ArrayList添加大量元素时，在这种情况下，ArrayList必须调整大小数次，
        // 这将导致性能不佳。对于这种情况ensureCapacity()，Java.util.ArrayList类的方法非常有用，
        // 因为它将ArrayList的大小增加了指定的容量
        ArrayList<String> stringList = new ArrayList<>();
        stringList.ensureCapacity(100);

        stringList.add("Hello");
        stringList.add("World");
        stringList.add("Java");
        System.out.println(stringList);

        // 是否为空
        System.out.println(stringList.isEmpty());

        // 长度
        System.out.println(stringList.size());

        // 截取
        System.out.println(stringList.subList(0, 1));

        // 包含
        System.out.println(stringList.contains("world"));

        // 查找 若没有返回 -1 ； 若有返回对应的索引值
        System.out.println(stringList.indexOf("Insert"));

        // 清空
        stringList.clear();

        System.out.println(stringList);
        System.out.println("============= ArrayList Function ============");
    }

    /**
     * 读读之间不互斥，读写之间也不互斥，只有写写之间要加锁互斥
     * 适合读多写少的场景
     */
    public static void copyOnWriteArrayList() {
        // CopyOnWriteArrayList 避免了多线程操作List线程不安全的问题
        // 原理： 就是在写的时候不对原集合进行修改，而是重新复制一份，修改完之后，再移动指针
        // add()在添加集合的时候加上了锁，保证了同步，避免了多线程写的时候会Copy出N个副本出来

        CopyOnWriteArrayList<String> stringList = new CopyOnWriteArrayList<>();
        stringList.add("Hello");
        stringList.add("Java");
        System.out.println(stringList);

        System.out.println("============= CopyOnWriteArrayList ============");
    }

    /**
     * ArrayDeque是Deque接口的一个实现, 用了可变数组，所以没有容量上的限制
     * 是线程不安全的，作为栈来使用效率高于stack，作为队列来使用，效率高于LinkedList
     * 数组的大小(即队列的容量)有特殊的要求，必须是 2^n
     */
    public static void arrayDeque() {
        // 底层是以数组实现的双向队列，大小是2的倍数 默认16 会进行双倍扩容
        // 队头队尾两个下标，如果队尾追上队头，则进行双倍的扩容
        // 队尾索引指的是下一个将要入队列的位置
        ArrayDeque<String> stringList = new ArrayDeque<>();
        stringList.add("queue1");
        stringList.add("queue2");
        stringList.add("queue3");
        System.out.println(stringList);
        System.out.println("============= arrayDeque ============");
    }

    /**
     * 线程安全队列实现
     */
    public static void concurrentLinkedQueue() {
        // 非阻塞 实现了依赖 CAS 的无锁算法
        // 非阻塞线程安全队列
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        // 非阻塞线程安全列表
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();

        // 同步队列，在线程池中用到
        SynchronousQueue<String> strings = new SynchronousQueue<>();
    }

    public static void main(String[] args) {
//        arrayList();
//        linkedList();
//        stackList();
//        arrayListFunction();
//        copyOnWriteArrayList();
//        arrayDeque();
//        concurrentLinkedQueue();
    }
}
