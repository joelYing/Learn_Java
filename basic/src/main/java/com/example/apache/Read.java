package com.example.apache;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @PackageName com
 * @Author joel
 * @Date 2019/2/20 14:24
 **/

public class Read {
    /**
     *  读取文件生成 ArrayList<ArrayList<Double>>
     */
    private static ArrayList<ArrayList<Double>> toArrayListDouble(ArrayList<String> content) {
        ArrayList<ArrayList<Double>> arrlistArrayList = new ArrayList<>();

        for (String c : content) {
            String[] s = c.split(",");
            ArrayList<Double> doubleArrayList = new ArrayList<>();

            for (String i : s) {
                double d = Double.parseDouble(i);
                // 每一行成为ArrayList<Double>
                doubleArrayList.add(d);
            }
            arrlistArrayList.add(doubleArrayList);
        }
        return arrlistArrayList;
    }

    private static void fileReader(String filepath) {
        File file = new File(filepath);

        try {
            ArrayList<String> content = (ArrayList<String>) FileUtils.readLines(file, "utf-8");

            ArrayList<ArrayList<Double>> arrlistArrayList = toArrayListDouble(content);

            System.out.println(arrlistArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // D:\mygit\learn_javagit\Learn_Java\basic\data\tm_10_raw
        System.out.println("input filepath : ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        fileReader(path);
    }
}
