package com.spiders.baidu_news_spider.bean;

import java.util.HashMap;

/**
 * @PackageName com.spiders
 * @Author joel
 * @Date 2019/1/11 14:41
 **/
public class NewsFeed {
    private HashMap<String, Object> feed;

    public HashMap<String, Object> getFeed() {
        return feed;
    }

    public void setFeed(HashMap<String, Object> feed) {
        this.feed = feed;
    }
}
