package innerclasspackage;

/**
 * @PackageName main.innerclasspackage
 * @Author joel
 * @Date 2018/12/17 11:04
 **/

/*
内部类的访问特点：
		A:内部类可以直接访问外部类的成员，包括私有。
		B:外部类要访问内部类的成员，必须创建对象。
 */

//class Outer {
//    private int num = 30;
//
//    // 内部类
//
//    class Inner {
//        public void show() {
//            System.out.println(num);
//        }
//    }
//
//    public void method() {
//        Inner i = new Inner();
//        i.show();
//    }
//}
//
//public class InnerclassDemo1 {
//    public static void main(String[] args) {
//        Outer.Inner i = new Outer().new Inner();
//        i.show();
//    }
//}



/**
匿名内部类
 */

interface Inter {
    public abstract void show();
    public abstract void show2();
}

class Outer {
    private int num = 30;

    public void method() {
        new Inter() {
            @Override
            public void show() {
                System.out.println("show");
            }

            @Override
            public void show2() {
                System.out.println("show2");
            }
        }.show();

        new Inter() {
            @Override
            public void show() {
                System.out.println("show");
            }

            @Override
            public void show2() {
                System.out.println("show2");
            }
        }.show2();

        Inter i = new Inter() {
            @Override
            public void show() {
                System.out.println("show");
            }

            @Override
            public void show2() {
                System.out.println("show2");
            }
        };

        i.show();
        i.show2();

    }
}

class InnerclassDemo1 {
    public static void main(String[] args) {
        Outer o = new Outer();
        o.method();
    }
}


