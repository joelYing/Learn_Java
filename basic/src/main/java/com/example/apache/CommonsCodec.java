package com.example.apache;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.net.URLCodec;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @PackageName apache
 * @Author joel
 * @Date 2018/12/28 11:20
 **/
public class CommonsCodec {

    private static String data = "hello, 中国";

    public static void md5() {
        String md5 = DigestUtils.md5Hex(data);
        System.out.println(md5);

        System.out.println("===== md5 =====");
    }

    public static void sha() {
        String sha1 = DigestUtils.sha1Hex(data);
        String sha256 = DigestUtils.sha256Hex(data);

        System.out.println(sha1);
        System.out.println(sha256);
        System.out.println("===== sha =====");
    }

    public static void base64() {
        String encode = Base64.encodeBase64String(data.getBytes());
        byte[] decode = Base64.decodeBase64(encode);

        System.out.println(encode);
        System.out.println(new String(decode));

        String safeEncode = Base64.encodeBase64URLSafeString(data.getBytes());
        byte[] safeDecode = Base64.decodeBase64(safeEncode);

        System.out.println(safeEncode);
        System.out.println(new String(safeDecode));
        System.out.println("===== base64 =====");
    }

    public static void url() {
        String url = "http://www.baidu.com/";
        URLCodec urlCodec = new URLCodec();

        String encode1 = null;
        try {
            encode1 = urlCodec.encode(url);
        } catch (EncoderException e) {
            e.printStackTrace();
        }

        String encode2 = null;
        try {
            encode2 = URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(encode1);
        System.out.println(encode2);
    }

    public static void main(String[] args) {
        md5();
        sha();
        base64();
        url();
    }
}
