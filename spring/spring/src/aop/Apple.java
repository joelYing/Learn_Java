package aop;

/**
 * @PackageName aop
 * @Author joel
 * @Date 2019/1/24 16:11
 **/
public class Apple implements Fruits{
    @Override
    public void price() {
        System.out.println("apple wang change price...");
    }
}
