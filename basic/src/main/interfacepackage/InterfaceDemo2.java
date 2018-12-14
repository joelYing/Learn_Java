package main.interfacepackage;

/**
 * @PackageName main.interfacepackage
 * @Author joel
 * @Date 2018/12/14 16:09
 **/

// 说英语

interface SpeakEnglish {
    public abstract void speak();
}

// 抽象人类

abstract class AbstractPeople {
    private String name;
    private int age;

    public AbstractPeople() {}

    public AbstractPeople(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sleep() {
        System.out.println("sleep");
    }

    public abstract void eat();
}

// 抽象教练类

abstract class AbstractCoach extends AbstractPeople {
    public AbstractCoach() {}

    public AbstractCoach(String name, int age) {
        super(name, age);
    }

    public abstract void teach();
}

abstract class AbstractPlayer extends AbstractPeople {
    public AbstractPlayer() {}

    public AbstractPlayer(String name, int age) {
        super(name, age);
    }

    public abstract void study();
}

class PingPongCoach extends AbstractCoach implements SpeakEnglish {
    public PingPongCoach() {}

    public PingPongCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println("pingpong coach speak english");
    }

    @Override
    public void eat() {
        System.out.println("pingpong coach eat apple");
    }

    @Override
    public void teach() {
        System.out.println("pingpong teach pingpong");
    }
}

class BasketballCoach extends AbstractCoach implements SpeakEnglish {
    public BasketballCoach() {}

    public BasketballCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println("basketball coach speak english");
    }

    @Override
    public void eat() {
        System.out.println("basketball coach eat meat");
    }

    @Override
    public void teach() {
        System.out.println("basketball teach basketball");
    }
}

class PingPongPlayer extends AbstractPlayer implements SpeakEnglish {
    public PingPongPlayer() {}

    public PingPongPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println("pingpong play speak english");
    }

    @Override
    public void eat() {
        System.out.println("pingpong play eat egg ");
    }

    @Override
    public void study() {
        System.out.println("pingpong play study pingpong");
    }
}

class BasketballPlayer extends AbstractPlayer {
    public BasketballPlayer() {}

    public BasketballPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("basketball play eat pig ");
    }

    @Override
    public void study() {
        System.out.println("basketball play study basketball");
    }
}

public class InterfaceDemo2 {
    public static void main(String[] args) {
        AbstractPlayer ap = new PingPongPlayer("A", 21);
        ap.eat();
        ((PingPongPlayer) ap).speak();
        ap.study();
    }
}
