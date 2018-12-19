package innerclasspackage;

/**
 * @PackageName main.innerclasspackage
 * @Author joel
 * @Date 2018/12/17 11:43
 **/

//class Outer2 {
//    private int num = 30;
//
//    public Outer2() {
//        System.out.println(this.num);
//    }
//
//    class Inter {
//        public int num = 20;
//        public void show() {
//            int num = 10;
//            System.out.println(this.num);
//            System.out.println(num);
//        }
//    }
//}
//
//public class InnerclassDemo2 {
//    public static void main(String[] args) {
//        Outer2.Inter oi = new Outer2().new Inter();
//        oi.show();
//    }
//}

interface Inter2 {
    public abstract void show();
}

class Outer3 {
    public static Inter2 method() {
        return new Inter2() {
            @Override
            public void show() {
                System.out.println("helloWorld");
            }
        };
    }
}

class InnerclassDemo2 {
    public static void main(String[] args) {
        // 匿名内部类
        Outer3.method().show();
    }
}

