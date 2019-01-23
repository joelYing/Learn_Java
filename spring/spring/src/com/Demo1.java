package com;

/**
 * @PackageName com
 * @Author joel
 * @Date 2019/1/23 15:26
 **/
public class Demo1 {
    private Demo1() {

    }

    // 延迟加载实例

    private static class DemoSingleHolder {
        static Demo1 instance = new Demo1();
    }

    // 返回实例

    public static Demo1 getInstance() {
        return DemoSingleHolder.instance;
    }
}
