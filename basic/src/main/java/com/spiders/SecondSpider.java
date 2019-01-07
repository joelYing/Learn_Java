package com.spiders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @PackageName com.spiders
 * @Author joel
 * @Date 2019/1/7 16:59
 **/
public class SecondSpider {
    public static String miListInfo ="</a>.*?<a href=\"(.*?)\" class=\"category-list-title\">(.*?)</a>";
    public static void getMiList() {
        StringBuilder result = new StringBuilder();
        String line = null;
        BufferedReader br = null;
        try {
            URL testurl = new URL("https://list.mi.com/");
            URLConnection urlConnection = testurl.openConnection();

            urlConnection.connect();
            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
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

        Pattern pattern = Pattern.compile(miListInfo);
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()) {
            // matcher.group() 应该是从 1 开始取
            System.out.println(matcher.group(1) + " : " + matcher.group(2));

        }
    }

    public static void main(String[] args) {
        getMiList();
    }
}
