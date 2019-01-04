package com.spiders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @PackageName com.spiders
 * @Date 2019/1/4 13:43
 **/
public class FirstSpider {
    public static final String houseInfo = "<div class=\"hong\"><img src=\"(.*?)\".*?>.*?<p class=\\\"bb\\\">(.*?)</p>";
    public static void getPictures() {

        StringBuilder result = new StringBuilder();
        BufferedReader br = null;
        try {
            URL testurl = new URL("http://www.imdb.cn/imdb250/1");
            URLConnection urlConnection = testurl.openConnection();

            urlConnection.connect();
            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            System.out.println(urlConnection.getHeaderFields());

            String line;
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
        System.out.println(result);

    }

    public static void main(String[] args) {
        getPictures();
    }
}
