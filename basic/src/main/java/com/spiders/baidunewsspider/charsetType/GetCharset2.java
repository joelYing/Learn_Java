package com.spiders.baidunewsspider.charsetType;

import info.monitorenter.cpdetector.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * @PackageName com.spiders.baidunewsspider
 * @Author joel
 * @Date 2019/1/22 11:20
 **/
public class GetCharset2 {
    /**
     * 方法一
     */
    public static String getUrlCharset(String url){
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            System.out.println("Content-Type" + "--->" + map.get("Content-Type"));
            List<String> list=map.get("Content-Type");
            if (list.size()>0){
                String contentType=list.toString().toUpperCase();
                if (contentType.contains("UTF-8")){
                    return "UTF-8";
                }
                if(contentType.contains("gb2312")){
                    return "GB2312";
                }
                if(contentType.contains("GB2312")){
                    return "GB2312";
                }
                if (contentType.contains("GBK")){
                    return "GBK";
                }
                if (contentType.contains("utf-8")){
                    return "UTF-8";
                }
            }

            //如果相应头里面没有编码格式,用下面这种
            CodepageDetectorProxy codepageDetectorProxy = CodepageDetectorProxy.getInstance();
            codepageDetectorProxy.add(JChardetFacade.getInstance());
            codepageDetectorProxy.add(ASCIIDetector.getInstance());
            codepageDetectorProxy.add(UnicodeDetector.getInstance());
            codepageDetectorProxy.add(new ParsingDetector(false));
            codepageDetectorProxy.add(new ByteOrderMarkDetector());
            Charset charset = codepageDetectorProxy.detectCodepage(new URL(url));
            System.out.println(charset.name());
            return charset.name();
        }catch (Exception e){}
        return null;
    }

    /**
     * 方法二
     */
    public static String getUrlEncode(URL url) {
        /*
         * detector是探测器，它把探测任务交给具体的探测实现类的实例完成。
         * cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法 加进来，如ParsingDetector、
         * JChardetFacade、ASCIIDetector、UnicodeDetector。
         * detector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的
         * 字符集编码。使用需要用到三个第三方JAR包：antlr.jar、chardet.jar和cpdetector.jar
         * cpDetector是基于统计学原理的，不保证完全正确。
         */
        CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
        /*
         * ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于
         * 指示是否显示探测过程的详细信息，为false不显示。
         */
        detector.add(new ParsingDetector(false));
        detector.add(new ByteOrderMarkDetector());
        /*
         * JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码
         * 测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以
         * 再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。
         *
         * 用到antlr.jar、chardet.jar
         */
        detector.add(JChardetFacade.getInstance());
        // ASCIIDetector用于ASCII编码测定
        detector.add(ASCIIDetector.getInstance());
        // UnicodeDetector用于Unicode家族编码的测定
        detector.add(UnicodeDetector.getInstance());


        java.nio.charset.Charset charset = null;
        try {
            charset = detector.detectCodepage(url);
        } catch (Exception ex) {
//            ex.printStackTrace()
            System.out.println("error response");
        }
        if (charset != null) {
            return charset.name();
        }
        return null;
    }
}
