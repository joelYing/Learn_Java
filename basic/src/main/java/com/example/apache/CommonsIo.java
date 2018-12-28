package com.example.apache;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @PackageName com.apache
 * @Author joel
 * @Date 2018/12/28 12:00
 **/
public class CommonsIo {
    private static String url = "http://www.baidu.com/";
    private static String userDir = System.getProperties().getProperty("user.dir");
    private static String DS = File.separator;
    private static String dirPath = userDir + DS + "data";

    public static void url() {
        InputStream ins = null;
        File file = new File(dirPath + DS + "baidu.html");
        try {
            ins = new URL(url).openStream();
            System.out.println(IOUtils.toString(ins, "UTF-8"));

            URL url = new URL(CommonsIo.url);
            // 把URL 里面内容复制到文件。可以下载文件
            FileUtils.copyURLToFile(url, file);
            System.out.println(FileUtils.sizeOf(file));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(ins);
        }
        System.out.println("===== url =====");
    }

    public static void file() {
        File file = new File(dirPath + DS + "common-io.txt");
        try {
            FileUtils.writeStringToFile(file, "hello", "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("===== file =====");
    }

    public static void filename() {
        String filename = dirPath + DS + "common-io.txt";
        System.out.println(FilenameUtils.getExtension(filename));
        System.out.println(FilenameUtils.getFullPath(filename));
        System.out.println(FilenameUtils.getFullPathNoEndSeparator(filename));
        System.out.println(FilenameUtils.getName(filename));
        System.out.println(FilenameUtils.normalize(filename));
        System.out.println(FilenameUtils.separatorsToWindows(filename));
        System.out.println("===== filename =====");
    }

    public static void main(String[] args) {
        url();
        file();
        filename();
    }
}
