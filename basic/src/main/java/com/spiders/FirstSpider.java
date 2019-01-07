package com.spiders;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @PackageName com.spiders
 * @Date 2019/1/4 13:43
 * 爬取IMDB资料库_TOP250_电影 通过 正则 + copyURLToFile
 **/
public class FirstSpider {
    public static String House_Info = "<div class=\"hong\"><img src=\"(.*?)\".*?>.*?<p class=\"bb\">(.*?)</p>";
    public static String userDir = System.getProperties().getProperty("user.dir");
    public static String DS = File.separator;
    public static String dirPath = userDir + DS + "data" + DS + "movieimage";

    public static void getPictures(String page) {
        StringBuilder result = new StringBuilder();
        String line = null;
        BufferedReader br = null;
        try {
            URL testurl = new URL("http://www.imdb.cn/imdb250/" + page);
            URLConnection urlConnection = testurl.openConnection();

            urlConnection.connect();
            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            // System.out.println(urlConnection.getHeaderFields())

            while((line = br.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // System.out.println(result)

        Pattern pattern = Pattern.compile(House_Info);
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()) {
            // matcher.group() 应该是从 1 开始取
            System.out.println(matcher.group(1) + " : " + matcher.group(2));
            downLoad(matcher.group(1), matcher.group(2) + ".jpg");
            System.out.println(matcher.group(2) + " 封面保存成功");
        }
    }

    public static void downLoad(String imageUrl, String imageName) {
        try {
            URL movieUrl = new URL(imageUrl);
            File dirFile = new File(dirPath);

            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }

            // 此方法可以将任何网址的后台页面内容拷贝到文件内
            try {
                FileUtils.copyURLToFile(movieUrl, new File(dirPath + DS + imageName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public static void getAllPictures() {
        for (int i = 1; i <= 10; i++) {
            getPictures(Integer.toString(i));
        }
    }

    public static void main(String[] args) {
        getAllPictures();
    }
}
