package aop;

/**
 * @PackageName aop
 * @Author joel
 * @Date 2019/1/24 16:11
 **/
public class Apple implements Fruits{
    private int price;
    {
        System.out.println("at first, spple price is : " + price);
    }
    @Override
    public void changePrice(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
