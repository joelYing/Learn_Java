package aop;

/**
 * @PackageName aop
 * @Author joel
 * @Date 2019/1/24 16:08
 **/
public class Advice {
    public void changeBefore() {
        System.out.println("price change before...");
    }

    public void changeAfter() {
        System.out.println("price change after...");
    }

    public void errorAfter() {
        System.out.println("price change error...");
    }
}
