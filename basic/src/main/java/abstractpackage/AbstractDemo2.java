package abstractpackage;

/**
 * @PackageName main.abstractpackage
 * @Author joel
 * @Date 2018/12/14 15:23
 **/

abstract class AbstractEmployee {
    private String name;
    private String eid;
    private int salary;

    public AbstractEmployee() {}

    public AbstractEmployee(String name, String eid, int salary) {
        this.name = name;
        this.eid = eid;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void show() {
        System.out.println(name + "---" + eid + "---" + salary);
    }

    public abstract void work();
}

class Programmer extends AbstractEmployee {
    public Programmer() {}
    public Programmer(String name, String eid, int salary) {
        super(name, eid, salary);
    }

    @Override
    public void work() {
        System.out.println("程序员-码代码");
    }
}

class Manager extends AbstractEmployee {
    private int bonus;

    public Manager() {}

    public Manager(String name, String eid, int salary, int bonus) {
        super(name, eid, salary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理谈需求");
    }

    @Override
    public void show() {
        super.show();
        System.out.println("经理奖金是： " + bonus);
    }
}

public class AbstractDemo2 {
    public static void main(String[] args) {
        // 程序员
        Programmer p = new Programmer("李白", "12138", 100000);
        p.show();
        p.work();
        System.out.println("----------------------------");

        // 经理
        AbstractEmployee ae = new Manager("太白", "12345", 80000, 5000);
        ae.show();
        ae.work();
    }
}
