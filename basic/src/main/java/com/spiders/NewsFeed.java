package com.spiders;

import java.util.HashMap;

/**
 * @PackageName com.spiders
 * @Author joel
 * @Date 2019/1/11 14:41
 **/
public class NewsFeed {
    private HashMap<String, String> feed;

    public HashMap<String, String> getFeed() {
        return feed;
    }

    public void setFeed(HashMap<String, String> feed) {
        this.feed = feed;
    }
}
