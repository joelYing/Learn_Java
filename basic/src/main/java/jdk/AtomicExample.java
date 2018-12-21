package jdk;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @PackageName jdk
 * @Author joel
 * @Date 2018/12/20 18:01
 **/
public class AtomicExample {
    /**
     类似 AtomicLong 提供原子操作方法，支持多线程
     借助CAS 比较并交换的算法 是一种乐观锁
     内存值V，预期值A，新值B，当且仅当预期值A和内存值V相同时，将内存值修改为B并返回true，否则什么都不做，并返回false。
     */

    public static void main(String[] args) {
        simple();
        atomic();
    }

    public static void simple() {
        SimpleCounter counter = new SimpleCounter();
        SimpleThread simpleThread = new SimpleThread(counter);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(simpleThread);
            thread.start();
        }

        // 主线程等待
        try {
            Thread.sleep(1000);
            System.out.println(counter.getCounter());
            System.out.println("=== simple ===");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void atomic() {
        AtomicCounter atomicCounter = new AtomicCounter();
        AtomicThread atomicThread = new AtomicThread(atomicCounter);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(atomicThread);
            thread.start();
        }

        try {
            Thread.sleep(1000);
            System.out.println(atomicCounter.getCounter());
            System.out.println("=== atomic ===");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 计数器
     */
    public static class SimpleCounter {
        private long counter = 0;
        public long getCounter() {
            return counter;
        }
        // 如果不用同步，多线程的情况下得不到正确的计数器结果

        public void increment() {
            counter++;
        }
    }

    public static class AtomicCounter {
        private AtomicLong counter = new AtomicLong(0);
        public long getCounter() {
            return counter.get();
        }
        public void increment() {
            counter.incrementAndGet();
        }
    }

    /**
     * 模拟一个线程执行10000次任务
     */
    public static class SimpleThread implements Runnable {
        /**
         在调用start方法之前通过线程类的构造方法将数据传入线程。
         并将传入的数据使用类变量保存起来，以便线程使用(其实就是在run方法中使用)
         */
        private SimpleCounter counter;
        private int x = 0;

        public SimpleThread(SimpleCounter counter) {
            this.counter = counter;
        }
        @Override
        public void run() {
            x++;
            System.out.println("SimpleThread: " + x + Thread.currentThread().getName() + " is runnning ");
            for (int i = 0; i < 10000; i++) {
                this.counter.increment();
            }
        }
    }

    public static class AtomicThread implements Runnable {
        private AtomicCounter counter;
        private int x = 0;

        public AtomicThread(AtomicCounter counter) {
            this.counter = counter;
        }
        @Override
        public void run() {
            x++;
            System.out.println("AtomicThread: " + x + Thread.currentThread().getName() + " is runnning ");
            for (int i = 0; i < 10000; i++) {
                this.counter.increment();
            }
        }
    }

}
