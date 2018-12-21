package thread;

/**
 * @PackageName thread
 * @Author joel
 * @Date 2018/12/20 16:47
 **/
public class ThreadDemo2 {
    public static void main(String[] args) {
        /*
        多线程两种实现方式 继承Thread 实现Runnable
        区别：
            1、继承Thread类，不能实现资源共享
            2、避免Java单继承特性带来的局限
            3、增强程序健壮性
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
