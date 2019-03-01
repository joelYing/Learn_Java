package com.example.thread;

/**
 * @PackageName thread
 * @Author joel
 * @Date 2018/12/20 16:47
 **/
public class ThreadDemo2 {
    public static void main(String[] args) {
        /*
        实现Runnable接口比继承Thread类所具有的优势：

        1）：适合多个相同的程序代码的线程去处理同一个资源

        2）：可以避免java中的单继承的限制

        3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立

        4）：线程池只能放入实现Runable或callable类线程，不能直接放入继承Thread的类
         */

//        for (int i = 0; i < 5; i++) {
//            ExtendThread extendThread = new ExtendThread();
//            extendThread.start();
//        }

        // 可以实现资源共享，即5个Thread共同实现一个runnable

        Runnable runnable = new RunnableThread();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

    public static class ExtendThread extends Thread {
        private int ticket = 5;
        private int counter = 0;

        @Override
        public void run() {
            counter++;
            System.out.println(counter + ": ExtendThread: " + getName() + " running");
            for (int i = 0; i < 10; i++) {
                 if (ticket > 0) {
                     System.out.println("extend ticket=" + ticket--);
                 }
            }
        }
    }

    public static class RunnableThread implements Runnable {
        private int ticket = 5;
        private int counter = 0;

        @Override
        public void run() {
            counter++;
            System.out.println(counter + ":RunnableThread: " + Thread.currentThread().getName() + " running");
            for (int i = 0; i < 10; i++) {
                 if (ticket > 0) {
                     System.out.println("runnable ticket=" + ticket--);
                 }

            }
        }
    }
}
