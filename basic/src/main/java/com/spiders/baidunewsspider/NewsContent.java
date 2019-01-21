package com.spiders.baidunewsspider;

import cn.edu.hfut.dmic.contentextractor.ContentExtractor;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.DateUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.DefaultCookieSpec;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @PackageName com.spiders.baidunewsspider
 * @Author joel
 * @Date 2019/1/17 12:04
 **/
public class NewsContent {
    /**
     * 这个cookie中的Expires属性是时间戳形式，并不符合标准的时间格式，因此，httpclient对于cookie的处理失效
     * 最终无法获取到cookie，并且发出了一条警告信息
     *
     * 解决方法
     *
     * 1、自定义一个CookieSpec类，继承DefaultCookieSpec
     * 2、重写parser方法
     * 3、将Cookie中的expires转换为正确的时间格式
     * 4、调用默认的解析方法
     */
    static class MyCookieSpec extends DefaultCookieSpec {
        @Override
        public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException {
            String value = header.getValue();
            String prefix = "Expires=";
            if (value.contains(prefix)) {
                String expires = value.substring(value.indexOf(prefix) + prefix.length());
                expires = expires.substring(0, expires.indexOf(";"));
                String date = DateUtils.formatDate(new Date(Long.parseLong(expires) * 1000L),"EEE, dd-MMM-yy HH:mm:ss z");
                value = value.replaceAll(prefix + "\\d{10};", prefix + date + ";");
            }
            header = new BasicHeader(header.getName(), value);
            return super.parse(header, cookieOrigin);
        }
    }

    public static String newsContent(String newsUrl) {
        String content = "";

        CloseableHttpClient httpClient  = HttpClients.custom()
                .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) " +
                        "Chrome/36.0.1985.125 Safari/537.36")
                .build();

        Registry<CookieSpecProvider> cookieSpecProviderRegistry = RegistryBuilder.<CookieSpecProvider>create()
                .register("myCookieSpec", context -> new MyCookieSpec()).build();

        HttpClientContext context = HttpClientContext.create();
        context.setCookieSpecRegistry(cookieSpecProviderRegistry);

        HttpGet httpGet = new HttpGet(newsUrl);
        httpGet.setConfig(RequestConfig.custom().setCookieSpec("myCookieSpec").build());

        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            String response = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

            content = ContentExtractor.getContentByHtml(response);
        } catch (Exception e) {
            System.out.println("解析失败");
        }

        return content;
    }

    public static void testHttpClient() {
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
}
