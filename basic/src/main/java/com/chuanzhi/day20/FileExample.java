package com.chuanzhi.day20;

import java.io.*;

/**
 * @PackageName com.chuanzhi.day20
 * @Author joel
 * @Date 2019/1/9 12:16
 **/
public class FileExample {
    public static String userDir = System.getProperties().getProperty("user.dir");
    public static String DS = File.separator;
    public static String dirPath = userDir + DS + "data" + DS + "chuanzhi";

    /**
     * 创建文件，并写入
     */
    public static void makeFiles() {
        for (int i = 1; i < 4; i++) {
            File file = new File(dirPath + DS + "text" + Integer.toString(i) + ".txt");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bytes1 = ("java" + Integer.toString(i)).getBytes();
                    fileOutputStream.write(bytes1);
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("===== already makefiles =====");
    }

    /**
     * 删除文件
     */
    public static void deleteFolder() {
        for (int i = 1; i < 4; i++) {
            File file = new File(dirPath + DS + "text" + Integer.toString(i) + ".txt");
            if (file.exists()) {
                file.delete();
            }
        }
        System.out.println("===== already delete =====");
    }

    /**
     * 以字节流方式读取文件内容
     */
    public static void readFile() {
        for (int i = 1; i < 4; i++) {
            File file = new File(dirPath + DS + "text" + Integer.toString(i) + ".txt");
            if (file.exists()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bytes1 = new byte[(int) file.length()];
                    // System.out.println(new String(bytes1))

                    for (int j = 0; j < bytes1.length; j++) {
                        bytes1[j] = (byte) fileInputStream.read();
                    }
                    System.out.println(new String(bytes1));
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("===== already readfiles =====");
    }

    /**
     * copy文件
     */
    public static void fileCopy() {
        try {
            FileInputStream fileInputStream = new FileInputStream(dirPath + DS + "text1.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(dirPath + DS + "copytext1.txt");

            int by;
            while ((by = fileInputStream.read()) != -1) {
                fileOutputStream.write(by);
            }

            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("===== already copy =====");
    }

    public static void main(String[] args) {
//        deleteFolder();
//        makeFiles();
//        readFile();
        fileCopy();
    }
}
