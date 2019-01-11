package com.spiders;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

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
 * @Date 2019/1/11 9:55
 **/
public class BaiduNews {
    // pn=(页数-1)*20

    public static String baiduNewsUrl = "http://news.baidu.com/ns?word=%s&pn=%s&cl=2&ct=0&tn=json&rn=20&ie=utf-8&bt=0&et=0&clk=sortbytime";
    public static String entry = "\"entry\":\\[(.*?)\\]";
    public static String feed = "\"feed\":(.*?)}}";
    public static void getNewsUrl() {
        StringBuilder result = new StringBuilder();
        String line = null;
        BufferedReader br = null;

        try {
            URL jsonUrl = new URL(String.format(baiduNewsUrl, "张小龙微信公开课", "0"));

            URLConnection urlConnection = jsonUrl.openConnection();
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36");
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
        String json = result.toString().replaceAll(" ", "");

        Pattern pattern = Pattern.compile(feed);
        Matcher matcher = pattern.matcher(json);
        while (matcher.find()) {
            // matcher.group() 应该是从 1 开始取
            System.out.println(matcher.group(1) + "}");
            String json2 = matcher.group(1) + "}";

            String jsonResult = JSON.toJSONString(json2, SerializerFeature.BrowserCompatible,
                    SerializerFeature.WriteMapNullValue);
            NewsResponse jo = JSON.parseObject(jsonResult, NewsResponse.class);
            String newsResponse = jo.getDescription();
            System.out.println(newsResponse);
        }
    }

    public static void main(String[] args) {
        getNewsUrl();
    }
}
