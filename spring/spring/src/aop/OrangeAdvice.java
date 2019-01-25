package aop;

/**
 * @PackageName aop
 * @Author joel
 * @Date 2019/1/25 14:22
 **/
public class OrangeAdvice implements Orange{
    @Override
    public void wantChangePrice() {
        System.out.println("it's new method . Orange want change price...");
    }
}
