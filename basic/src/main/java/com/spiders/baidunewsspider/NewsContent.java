package com.spiders.baidunewsspider;

import cn.edu.hfut.dmic.contentextractor.ContentExtractor;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @PackageName com.spiders.baidunewsspider
 * @Author joel
 * @Date 2019/1/17 12:04
 **/
public class NewsContent {
    public static void newsContent(String newsUrl) {
        CloseableHttpClient httpClient  = HttpClients.custom()
                .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) " +
                        "Chrome/36.0.1985.125 Safari/537.36")
                .build();
        HttpGet httpGet = new HttpGet(newsUrl);

        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            String response = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

            String content = ContentExtractor.getContentByHtml(response);
            System.out.println(content);
        } catch (Exception e) {
            System.out.println("解析失败");
        }
    }

    public static void testHttpClient() {
        // test
//        String newsUrl = null;
//        CloseableHttpClient httpClient  = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet(newsUrl);
//
//        try {
//            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
//            String response = EntityUtils.toString(httpResponse.getEntity());
//
//            System.out.println(response);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Http 响应
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
        System.out.println(response.getProtocolVersion());
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getReasonPhrase());
        System.out.println(response.getStatusLine().toString());

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.donews.com/news/detail/4/3034544.html");
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                InputStream inputStream = entity.getContent();
                try {
                    System.out.println(" ");
                } finally {
                    inputStream.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        newsContent("http://it.sohu.com/20190116/n561077122.shtml");
//    }
}
