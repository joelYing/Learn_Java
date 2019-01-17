package com.spiders.baidunewsspider.bean;

/**
 * @PackageName com.spiders
 * @Author joel
 * @Date 2019/1/11 14:41
 **/
public class NewsFeed {
    private NewsResponse feed;

    public NewsResponse getFeed() {
        return feed;
    }

    public void setFeed(NewsResponse feed) {
        this.feed = feed;
    }
}
