package com.spiders;

import java.util.HashMap;

/**
 * @PackageName com.spiders
 * @Author joel
 * @Date 2019/1/11 14:30
 **/
public class NewsData {
    private String title;
    private String url;
    private String urlEnc;
    private String source;
    private HashMap<String, String> newsCategory;
    private String abs;
    private String imgUrl;
    private long time;
    private int relate;
    private int same;
    private int newsPn;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlEnc() {
        return urlEnc;
    }

    public void setUrlEnc(String urlEnc) {
        this.urlEnc = urlEnc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public HashMap<String, String> getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(HashMap<String, String> newsCategory) {
        this.newsCategory = newsCategory;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getRelate() {
        return relate;
    }

    public void setRelate(int relate) {
        this.relate = relate;
    }

    public int getSame() {
        return same;
    }

    public void setSame(int same) {
        this.same = same;
    }

    public int getNewsPn() {
        return newsPn;
    }

    public void setNewsPn(int newsPn) {
        this.newsPn = newsPn;
    }
}
