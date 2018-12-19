public class MathDemo {
    public static void main(String[] args) {
        // 整数除法 结果为保留小数点前的数
        System.out.println(10/3);
        System.out.println(10/4);

        // 分子为小数 分母为整数 结果为小数
        System.out.println(10.0/3);
        System.out.println(10.0/4);

        // 两个都是小数
        System.out.println(10.0/3.0);

        // 求余数
        // 1
        System.out.println(10%3);
        // 1.5
        System.out.println(10.5%3);

        // 浮点型与整数比较 只要值相等就返回true
        float f = 5.0f;
        long l = 5;
        System.out.println(f==l);

        /*
         逻辑运算符
         一个& 与 两个& 情况不同  | 同理
         &&（短路运算符）情况下只要有一个表达式能确定结果，运算符右边的表达式不再计算
         */
        int n1 = 3;
        boolean b1 = (3<2)&((n1++)>2);
        System.out.println("b1 = " + b1 + " n1 = " + n1);

        int n2 = 3;
        boolean b2 = (3<2)&&((n2++)>2);
        System.out.println("b2 = " + b2 + " n2 = " + n2);

        // 条件运算符 ? 前的条件成立时返回 a1 不成立则返回a2
        int a1 = 10;
        int a2 = 6;
        int max;
        max = a1>a2?a1:a2;
        System.out.println("max = " + max);
        

        /* Java 的 Math 包含了用于执行基本数学运算的属性和方法，如初等指数、对数、平方根和三角函数。
        Math 的方法都被定义为 static 形式，通过 Math 类可以在主函数中直接调用。*/

        int a = 6;
        int b = 8;
        int maxAb = Math.max(a, b);
        int minAb = Math.min(a, b);
        System.out.println(maxAb);
        System.out.println(minAb);

        // 进位取整 大于该数的最小整数
        double d1 = 4.4;
        double d2 = 4.5;

        double ceil1 = Math.ceil(d1);
        double ceil2 = Math.ceil(d2);

        System.out.println(ceil1);
        System.out.println(ceil2);

        // 退位取整 小于该数的最大整数
        double floor1 = Math.floor(d1);
        double floor2 = Math.floor(d2);

        System.out.println(floor1);
        System.out.println(floor2);

        // 四舍五入
        double round1 = Math.round(d1);
        double round2 = Math.round(d2);

        System.out.println(round1);
        System.out.println(round2);

        // a 的 b 次幂
        double pow = Math.pow(d1, d2);
        System.out.println(pow);

        // public static double sqrt(double a):正平方根
        System.out.println("sqrt:" + Math.sqrt(16));
    }
}
