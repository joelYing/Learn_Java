package advance;

import okhttp3.*;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @PackageName advance
 * @Author joel
 * @Date 2018/12/26 10:00
 **/
public class OkhttpExample {
    public static void simple() throws IOException {
        // 简单实用OKhttp发送请求接受响应
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url("http://www.baidu.com/")
                .header("User-Agent", "Chrome")
                .build();

        Response response = client.newCall(request).execute();

        // 响应码
        if (!response.isSuccessful()) {
            throw new IOException("服务端错误" + response);
        }
        int httpCode = response.code();
        System.out.println("Status Code: " + httpCode);

        // 单个响应头
        String server = response.header("Server");
        System.out.println("Server: " + server);

        // 响应头数组
        Headers headers = response.headers();
        for (int i = 0; i < headers.size(); i++) {
            System.out.println(headers.name(i) + " : " + headers.value(i));
        }

        // 正文
        ResponseBody body = response.body();
        assert body != null;
        System.out.println("===");
        System.out.println(Objects.requireNonNull(body.contentType()).charset());
        System.out.println(Objects.requireNonNull(body.contentType()).type());
        System.out.println(body.contentLength());
        System.out.println("===");
        // 获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式
        System.out.println(body.string());
    }

    public static void cookie() throws IOException {
        // 保存cookie
        MyCookieJar cookieJar = new MyCookieJar();

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .cookieJar(cookieJar)
                .build();

        long ts = System.currentTimeMillis();
        String url = "http://weixin.sogou.com/antispider/util/seccode.php?tc=" + ts;

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        Request request1 = new Request.Builder()
                .url("http://www.baidu.com/")
                .header("User-Agent", "Chrome")
                .build();
        Response response1 = client.newCall(request1).execute();

        System.out.println(cookieJar.getCookies());
        System.out.println("===");
        assert response1.body() != null;
        System.out.println(response1.body().string());
    }

    public static void main(String[] args) {
        try {
//            simple();
            cookie();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
