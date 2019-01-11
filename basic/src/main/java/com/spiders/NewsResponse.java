package com.spiders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @PackageName com.spiders
 * @Author joel
 * @Date 2019/1/11 14:17
 **/
public class NewsResponse {
    private String requestUrl;
    private String updated;
    private String description;
    private String relateUrl;
    private HashMap<String, String> category;
    private HashMap<String, String> author;
    private int all;
    private int resultnum;
    private int pn;
    private int rn;
    private List<NewsData> entry = new ArrayList<>();

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelateUrl() {
        return relateUrl;
    }

    public void setRelateUrl(String relateUrl) {
        this.relateUrl = relateUrl;
    }

    public HashMap<String, String> getCategory() {
        return category;
    }

    public void setCategory(HashMap<String, String> category) {
        this.category = category;
    }

    public HashMap<String, String> getAuthor() {
        return author;
    }

    public void setAuthor(HashMap<String, String> author) {
        this.author = author;
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public int getResultnum() {
        return resultnum;
    }

    public void setResultnum(int resultnum) {
        this.resultnum = resultnum;
    }

    public int getPn() {
        return pn;
    }

    public void setPn(int pn) {
        this.pn = pn;
    }

    public int getRn() {
        return rn;
    }

    public void setRn(int rn) {
        this.rn = rn;
    }

    public List<NewsData> getEntry() {
        return entry;
    }

    public void setEntry(List<NewsData> entry) {
        this.entry = entry;
    }
}
