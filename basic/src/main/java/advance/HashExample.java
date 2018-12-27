package advance;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class HashExample {
    private static Hash hash = Hash.getInstance();
    private static String source = "hello，中国";

    public static void md5() {
        String md5 = null;
        try {
            md5 = hash.md5(source);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("md5: " + md5);
        System.out.println("===== md5 =====");
    }

    public static void sha() {
        String sha1 = null;
        String sha256 = null;
        try {
            sha1 = hash.sha(source);
            sha256 = hash.sha(source, 256);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("sha1: " + sha1);
        System.out.println("sha256: " + sha256);
        System.out.println("===== sha =====");
    }

    public static void base64() {
        // Java 9版本之后Base64Encoder和Base64Decoder无法继续使用
        // 使用java.util.Base64 中的 Encoder Decoder
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        String encode = encoder.encodeToString(source.getBytes());
        java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
        byte[] decode = decoder.decode(encode);
        System.out.println(encode);
        System.out.println(new String(decode));
        System.out.println("===== base64 =====");
    }

    public static void commonBase64() {
        String encode = Base64.encodeBase64String(source.getBytes());
        byte[] decode = Base64.decodeBase64(encode);
        System.out.println(encode);
        System.out.println(Arrays.toString(decode));
        System.out.println("===== commonBase64 =====");
    }

    public static void url() {
        String url = "http://www.baidu.com/";
        try {
            System.out.println(URLEncoder.encode(url, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("===== url =====");
    }

    public static void main(String[] args) {
        md5();
        sha();
        base64();
        commonBase64();
        url();
    }
}
