package com.spiders.baidunewsspider;
import com.spiders.baidunewsspider.bean.NewsData;
import com.spiders.baidunewsspider.database.SaveMysql;
import com.spiders.baidunewsspider.jsonparse.IncludeFeed;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

/**
 * @PackageName com.spiders
 * @Author joel
 * @Date 2019/1/11 9:55
 **/
public class BaiduNews {
    // pn=(页数-1)*20

    public static String baiduNewsUrl = "http://news.baidu.com/ns?word=%s&pn=%s&cl=2&ct=0&tn=json&rn=20&ie=utf-8&bt=0&et=0&clk=sortbytime";

    public static void getNewsUrl() {
        StringBuilder result = new StringBuilder();
        String line = null;
        BufferedReader br = null;

        try {
            URL jsonUrl = new URL(String.format(baiduNewsUrl, "张小龙微信公开课", "0"));

            URLConnection urlConnection = jsonUrl.openConnection();
            // 需要带上 user-agent
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
        // RemoveFeed.removefeed(result)

        // 得到每一页的 文章的 url
        List<NewsData> infoList = IncludeFeed.includeFeed(result);

        // 提取正文 在循环遍历一个集合时，删除某个元素会引起
        // java.util.ConcurrentModificationException
        // 原因在于 迭代器的 modCount 和 expectedModCount 的值不一致，解决办法之一可以使用 iterator

        Iterator<NewsData> iterator = infoList.iterator();
        while (iterator.hasNext()) {
            NewsData info = iterator.next();
            if (info.getTitle()  != null) {
                System.out.println(info.getUrl());
                String content = NewsContent.newsContent(info.getUrl());
                info.setContent(content);
            } else {
                iterator.remove();
            }
        }

        SaveMysql.insert(infoList);

    }

    public static void main(String[] args) {
        getNewsUrl();
    }
}
