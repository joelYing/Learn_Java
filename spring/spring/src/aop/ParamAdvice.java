package aop;

/**
 * @PackageName aop
 * @Author joel
 * @Date 2019/1/25 12:10
 **/
public class ParamAdvice {
    private int price;
    public void changePrice(int price) {
        System.out.println("boss decision change price...");
        this.price = price;
    }
}
