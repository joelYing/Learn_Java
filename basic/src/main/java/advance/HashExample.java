package advance;

import org.apache.commons.codec.binary.Base64;

import java.util.Arrays;

public class HashExample {
    // Java 9版本之后Base64Encoder和Base64Decoder无法继续使用

    private static String source = "hello，中国";

    public static void base64() {
        byte[] encode = Base64.encodeBase64(source.getBytes());
        byte[] decode = null;
        decode = Base64.decodeBase64(encode);
        System.out.println(Arrays.toString(encode));
        System.out.println(new String(decode));
    }

    public static void main(String[] args) {
        base64();
    }
}
