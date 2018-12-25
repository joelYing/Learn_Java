package jdk;

import java.io.*;
import java.net.*;

/**
 * @PackageName jdk
 * @Author joel
 * @Date 2018/12/25 15:48
 **/
public class NetExample {
    public static void host() {
        try {
            // 获取本机的IP
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
            // 本机IP
            System.out.println(localHost.getHostAddress());
            System.out.println("=====");

            // 获取主机IP
            InetAddress remoteHost1 = InetAddress.getByName("weibo.com");
            System.out.println(remoteHost1);
            System.out.println(remoteHost1.getHostAddress());

            InetAddress remoteHost2 = InetAddress.getByName("weibo.cn");
            System.out.println(remoteHost2);
            System.out.println(remoteHost2.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        System.out.println("===== host =====");
    }

    public static void get() {
        try {
            // url get
            URL url = new URL("http://www.baidu.com/");
            // connection
            URLConnection connection = url.openConnection();
            // 获取字节流
            InputStream is = connection.getInputStream();
            // 转换成字符流 InputStreamReader 是字节流转字符流的桥梁
            InputStreamReader isr = new InputStreamReader(is);
            // 缓冲区
            BufferedReader br = new BufferedReader(isr);

            System.out.println(connection.getContentLength());
            System.out.println(connection.getContentType());
            System.out.println(connection.getContentEncoding());
            System.out.println(connection.getContent());
            System.out.println(connection.getDefaultUseCaches());
            System.out.println(connection.getHeaderFields());
            System.out.println(connection.getURL());

            String line;
            StringBuilder string = new StringBuilder();
            while ((line = br.readLine()) != null) {
                string.append(line);
            }
            br.close();
            isr.close();
            is.close();

            System.out.println(string);
            System.out.println("===== http get =====");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void post() {
        try {
            URL url = new URL("http://www.baidu.com/");
            // post 必须使用HTTPURLConnection对象
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestProperty("encoding", "UTF-8");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write("aaa=xxx&bbb=xxx");
            bw.flush();

            System.out.println(connection.getURL());
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line;
            StringBuilder string = new StringBuilder();
            while ((line = br.readLine()) != null) {
                string.append(line);
            }

            bw.close();
            osw.close();
            os.close();
            br.close();
            isr.close();
            is.close();

            System.out.println(string);
            System.out.println("===== http post =====");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        host();
//        get();
//        post();
    }
}
