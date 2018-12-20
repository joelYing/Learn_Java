package thread;

/**
 * @PackageName thread
 * @Author joel
 * @Date 2018/12/20 16:20
 **/
public class ThreadDemo1 {
    public static void main(String[] args) {
        // 当前线程名称
        System.out.println(Thread.currentThread().getName());
        // 当前线程ID
        System.out.println(Thread.currentThread().getId());
        // 当前线程优先级
        System.out.println(Thread.currentThread().getPriority());

//        extendThread();
        runnableThread();
    }

    public static void extendThread() {
        for (int i = 0; i < 10; i++) {
             ExtendThread extendThread = new ExtendThread();
             extendThread.setName("e" + i);
             extendThread.start();
        }
    }

    public static void runnableThread() {
        RunnableThread runnableThread = new RunnableThread();
        for (int i = 0; i < 10; i++) {
             Thread thread = new Thread(runnableThread, "r" + i);
             thread.start();
        }
    }

    public static class ExtendThread extends Thread {
        // 当调用start方法后，线程开始执行run方法中的代码
        @Override
        public void run() {
            while (true) {
                System.out.println("ExtendThread: " + getName() + " running ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class RunnableThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("RunnableThread: " + Thread.currentThread().getName() + " running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
