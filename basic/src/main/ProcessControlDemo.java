package main;

import java.util.Random;
import java.util.Scanner;

/**
 * @PackageName main
 * @Author joel
 * @Date 2018/12/7 14:33
 **/
public class ProcessControlDemo {
    public static void main(String[] args) {
        // 嵌套if
        
        int a = 2, b = 3;
        if (a != b) {
            if (a > b) {
                System.out.println(a + "大于" + b);
            }else{
                System.out.println(a + "小于" + b);
            }
        }else{
            System.out.println(a + "和" + b + "相等");
        }

        // switch

        System.out.println("what day is it today: ");
        Scanner scanner = new Scanner(System.in);
        String day = scanner.next();
        // day.toUpperCase() 将输入都改为大写
        switch (day){
            case "Monday":
                System.out.println("星期一");
                break;
            case "Tuesday":
                System.out.println("星期二");
                break;
            case "Wednesday":
                System.out.println("星期三");
                break;
            case "Thursday":
                System.out.println("星期四");
                break;
            case "Friday":
                System.out.println("星期五");
                break;
            case "Saturday":
                System.out.println("星期六");
                break;
            case "Sunday":
                System.out.println("星期日");
                break;
            default:
                System.out.println("没有这一天");
        }

        // while 循环1

        int n = 1, sum = 0, max = 5;
        while(n <= max){
            sum = sum + n;
            n++;
        }
        System.out.println("sum = " + sum);

        // while 循环2

        char ch = 'a', max2 = 'z';
        int lines = 1;
        while(ch <= max2){
            System.out.print(" " + ch + " ");
            if(lines == 13){
                System.out.println();
            }
            ch++;
            lines++;
        }

        // 猜数字

        // do while 循环至少执行一次 循环条件之后的分号不能丢
        Random random = new Random();
        // 随机生成大于等于0不等于10的正整数
        int number = random.nextInt(10);
        int guess;
        do{
            System.out.println("\n请输入您猜测的0-9之间的数字：");
            Scanner scanner1 = new Scanner(System.in);
            guess = scanner1.nextInt();
            if(guess > number){
                System.out.println("有点大了");
            }else if(guess < number){
                System.out.println("有点小了");
            }
        }while(guess != number);
        System.out.println("恭喜 答案就是 " + guess);
    }
}
