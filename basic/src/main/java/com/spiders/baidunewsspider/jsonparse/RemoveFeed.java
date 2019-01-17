package com.spiders.baidu_news_spider.jsonparse;

import com.alibaba.fastjson.JSON;
import com.spiders.baidu_news_spider.bean.NewsData;
import com.spiders.baidu_news_spider.bean.NewsResponse;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @PackageName com.spiders.baidu_news_spider.jsonparse
 * @Author joel
 * @Date 2019/1/17 11:00
 **/
public class removeFeed {
    public static String feed = "\"feed\":(.*?)}}";
    public static void removefeed(StringBuilder result) {
        String json = result.toString().replaceAll(" ", "").replaceAll(",\\{}", "");

        Pattern pattern = Pattern.compile(feed);
        Matcher matcher = pattern.matcher(json);
        while (matcher.find()) {
            // matcher.group() 应该是从 1 开始取
            String response = matcher.group(1) + "}";
            // System.out.println(json2)
            NewsResponse res = JSON.parseObject(response, NewsResponse.class);
            List<NewsData> entrys = res.getEntry();

            for (NewsData entry : entrys) {
                System.out.println("title : " + entry.getTitle() + ", url : " + entry.getUrl() + ", source : " + entry.getSource() +
                        ", abs : " + entry.getAbs() + ", time : " + entry.getTime() + ", pn : " + entry.getPn());
                HashMap<String, String> categorys = entry.getCategory();
                System.out.println(categorys);
            }
        }
    }
}
