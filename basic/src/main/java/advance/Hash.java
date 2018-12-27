package advance;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @PackageName advance
 * @Author joel
 * @Date 2018/12/27 14:05
 **/
public class Hash {
    private static class HashHolder {
        private static final Hash INSTANCE = new Hash();
    }
    private Hash() {}

    public static final Hash getInstance() {
        return HashHolder.INSTANCE;
    }

    public static String BytesToHex(byte[] resultBytes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < resultBytes.length; i++) {
            // resultBytes[i] & 0xFF , 去掉resultBytes[i]的符号, 来掩掉其他多余24位
            // 比如当resultBytes[i]=1时十六进制字符串为1，加个0就转成了01，
            // 而resultBytes[i]=-1时候十六进制字符串为FF
            if (Integer.toHexString(0xff & resultBytes[i]).length() == 1) {
                builder.append("0").append(Integer.toHexString(0xff & resultBytes[i]));
            } else {
                builder.append(Integer.toHexString(0xff & resultBytes[i]));
            }
        }
        return builder.toString();
    }

    public String md5(String string) throws NoSuchAlgorithmException {
        // 接收任意大小的数据，并输出固定长度的哈希值
        // 选择使用的算法
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 重置摘要
        md.reset();
        md.update(string.getBytes());
        byte[] resultBytes = md.digest();

        // String resultString = BytesToHex(resultBytes)
        return BytesToHex(resultBytes);
    }

    public String md5File(String path) throws IOException, NoSuchAlgorithmException {
        FileInputStream fis = new FileInputStream(new File(path));
        DigestInputStream dis = new DigestInputStream(fis, MessageDigest.getInstance("MD5"));
        byte[] buffer = new byte[1024];
        int read = dis.read(buffer, 0, 1024);
        while (read != -1) {
            read = dis.read(buffer, 0, 1024);
        }

        MessageDigest md = dis.getMessageDigest();
        byte[] resultBytes = md.digest();
        return BytesToHex(resultBytes);
    }

    public String sha(String string, int type) throws NoSuchAlgorithmException {
        String mdStr = "SHA-" + type;
        MessageDigest md = MessageDigest.getInstance(mdStr);
        md.reset();
        md.update(string.getBytes());
        byte[] resultBytes = md.digest();

        return BytesToHex(resultBytes);
    }

    public String sha(String string) throws NoSuchAlgorithmException {
        return sha(string, 1);
    }
}
