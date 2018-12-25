package jdk;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @PackageName jdk
 * @Author joel
 * @Date 2018/12/25 11:20
 **/
public class IoExample {
    /**
     * 目录分隔符，避免不同操作系统下路径分隔符问题
     * getProperty("user.dir") 获取当前工程的路径
     */
    private final static String DS = File.separator;

    private final static String User_Dir = System.getProperties().getProperty("user.dir");

    private final static String Dir_Path = User_Dir + DS + "data";

    private static void mkfile(File file) {
        if (file.exists()) {
            boolean isdelete = file.delete();
        } else {
            try {
                boolean iscreate = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void file() {
        // 递归创建目录
        String subDirPath = Dir_Path + DS + "subdata";
        File dir = new File(subDirPath);
        boolean ismkdir = dir.mkdir();
        System.out.println(ismkdir);

        String filePath1 = Dir_Path + DS + "test.txt";
        String filePath2 = subDirPath + DS + "test.txt";
        File file1 = new File(filePath1);
        File file2 = new File(filePath2);

        mkfile(file1);
        mkfile(file2);

        System.out.println("===== file =====");
    }

    public static void listDir() {
        // 列出目录下所有文件
        File dirs = new File(Dir_Path);
        prints(dirs);

        System.out.println("===== listDir =====");
    }

    private static void prints(File dirs) {
        if (dirs.isDirectory()) {
            File[] f = dirs.listFiles();
            if (f != null) {
                // 若 f 存在，则递归调用 prints() 方法若是文件夹就列出其下所有文件大小及路径
                for (File aF : f) {
                    prints(aF);
                }
            }
        } else {
            System.out.println(dirs.length() + " : " + dirs);
        }
    }

    public static void fileStream() {
        File file = new File(Dir_Path + DS + "test1.txt");

        FileOutputStream output1, output2;
        FileInputStream input1, input2;
        try {
            // 文件字节输出流对象
            output1 = new FileOutputStream(file);
            String string = "helloworld";
            // 将数据转化为字节数组
            byte[] bytes = string.getBytes();
            // 全部写入
            output1.write(bytes);
            output1.write(bytes);
            output1.write("\r\n".getBytes());
            // 关闭流
            output1.close();

            // File对象的文件追加写入数据，默认为false，会重写该文件的数据
            output2 = new FileOutputStream(file, true);
            output2.write(bytes);
            output2.write(bytes);
            output2.write("\r\n".getBytes());
            output2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 从系统的某个文件中获得输入字节
        try {
            input1 = new FileInputStream(file);
            input2 = new FileInputStream(file);
            // 根据文件大小来创建字节数组
            byte[] ibytes1 = new byte[(int) file.length()];
            byte[] ibytes2 = new byte[(int) file.length()];
            // 返回读取字节的长度
            int len = input1.read(ibytes1);
            // 构建成字符串输出
            System.out.println(new String(ibytes1));
            System.out.println("=====");

            for (int i = 0; i < ibytes2.length; i++) {
                ibytes2[i] = (byte) input2.read();
            }
            System.out.println(new String(ibytes2));

            input1.close();
            input2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("===== firstStream =====");
    }

    public static void fileString() {
        // java给出的解释是使用字节流更好
        File file = new File(Dir_Path + DS + "test2.txt");
        try {
            FileWriter fw = new FileWriter(file);
            String string = "HelloWorld";
            fw.write(string);
            fw.write("\r\n");
            // 当执行完此方法后，字符数据还并没有写入到目的文件中去。此时字符数据会保存在缓冲区中
            fw.write(string);
            // 刷新该流中的缓冲。将缓冲区中的字符数据保存到目的文件中去
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Reader reader = new FileReader(file);
            int len = 0;
            char[] c = new char[1024];
            int temp = 0;
            // read() 读取单个字符。返回作为整数读取的字符，如果已达到流末尾，则返回 -1
            while ((temp = reader.read()) != -1) {
                c[len] = (char)temp;
                len++;
            }
            reader.close();
            System.out.println(new String(c, 0, len));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bufferReader() {
        // BufferedReader只接受字符流缓冲区，所以将System.in字节流转换为字符流放入内存缓冲区
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        try {
            // 输入两串数字
            string = bufferedReader.readLine();
            int a = Integer.parseInt(string);
            string = bufferedReader.readLine();
            int b = Integer.parseInt(string);
            System.out.println(a + b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void scanner() {
        Scanner scanner = new Scanner(System.in);
        String pattern = "^\\d{4}-\\d{2}-\\d{2}";
        String str = null;
        System.out.println("yyyy-MM-dd");
        if (scanner.hasNext(pattern)) {
            str = scanner.next(pattern);
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(date);
        }
    }

    public static void print() {
        // PrintStream 是打印输出流，它继承于FilterOutputStream
        // PrintStream 永远不会抛出 IOException；它产生的IOException会被自身的函数所捕获并设置错误标记
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(new File(Dir_Path + DS + "print.txt")));
            ps.println("print");
            ps.println("helloworld");
            ps.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        file();
//        listDir();
//        fileStream();
//        fileString();
//        bufferReader();
//        scanner();
        print();
    }
}
