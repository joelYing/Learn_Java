package com.spiders.baidunewsspider.jsonparse;

import com.alibaba.fastjson.JSON;
import com.spiders.baidunewsspider.bean.NewsData;
import com.spiders.baidunewsspider.bean.NewsFeed;
import java.util.List;

/**
 * @PackageName com.spiders.baidunewsspider.jsonparse
 * @Author joel
 * @Date 2019/1/17 11:12
 **/
public class IncludeFeed {
    // 直接把整个作为 json 来解析的情况， 使用 NewsFeed ，类型为 NewsResponse
    // List<NewsData> entrys = res.getFeed().getEntry(); 可对其进行操作

    public static void includeFeed(StringBuilder result) {
        String json = result.toString().replaceAll(" ", "");

        NewsFeed res = JSON.parseObject(json, NewsFeed.class);

        List<NewsData> entrys = res.getFeed().getEntry();

        for (NewsData entry : entrys) {
            if (entry.getTitle() != null) {
                System.out.println("title : " + entry.getTitle() + ", url : " + entry.getUrl() + ", source : "
                        + entry.getSource() + ", abs : " + entry.getAbs() + ", time : " + entry.getTime() +
                        ", pn : " + entry.getPn());
//                HashMap<String, String> categorys = entry.getCategory();
//                System.out.println(categorys);
            }
        }
    }
}
