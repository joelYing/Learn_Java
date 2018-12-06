package main;

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

    }
}
