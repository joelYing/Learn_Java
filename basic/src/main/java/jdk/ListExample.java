package jdk;

import java.util.*;

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
        String[] strAry = stringList.toArray(new String[] {});
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
        System.out.println(linkedList.poll());

        System.out.println(linkedList);
        System.out.println("============= LinkedList ============");
    }

    


    public static void main(String[] args) {
//        arrayList();
        linkedList();
    }
}
