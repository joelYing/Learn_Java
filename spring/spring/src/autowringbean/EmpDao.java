package autowringbean;

/**
 * @PackageName autowringbean
 * @Author joel
 * @Date 2019/1/24 14:18
 **/
public class EmpDao implements Emp {

    @Override
    public void play() {
        System.out.println("EmpDao : play...");
    }
}
