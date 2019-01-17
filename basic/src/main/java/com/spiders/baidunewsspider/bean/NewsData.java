package com.spiders.baidu_news_spider.bean;

import java.util.HashMap;

/**
 * @PackageName com.spiders
 * @Author joel
 * @Date 2019/1/11 14:30
 **/
public class NewsData {
    // 为了解析json而创建的实体类，其中的变量名应该与要解析部分json的键名一致
    // 如 json 中键为 "url" ,而变量为 private String urls
    // 这就会导致解析时找不到对应的 键 使得返回为 null

    private String title;
    private String url;
    private String urlEnc;
    private String source;
    private HashMap<String, String> category;
    private String abs;
    private String imgUrl;
    private long time;
    private int relate;
    private int same;
    private int pn;

    public long getTime() {
        return time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, String> getCategory() {
        return category;
    }

    public void setCategory(HashMap<String, String> category) {
        this.category = category;
    }

    public int getPn() {
        return pn;
    }

    public void setPn(int pn) {
        this.pn = pn;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

}
