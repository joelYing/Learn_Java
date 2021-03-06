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

    public static List<NewsData> includeFeed(StringBuilder result) {
        // 去除空格
        String json = result.toString().replaceAll(" ", "");

        // 提取 feed 中的内容
        NewsFeed res = JSON.parseObject(json, NewsFeed.class);

        // 取出 NewsResponse 类型的 feed 中的 List<NewsData> 类型的 entrys

        return res.getFeed().getEntry();
    }
}
