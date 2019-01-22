package com.spiders.baidunewsspider.charsetType;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;
import java.io.IOException;
import java.io.InputStream;

/**
 * @PackageName com.spiders.baidunewsspider
 * @Author joel
 * @Date 2019/1/22 10:48
 **/

public class GetCharset {
    public static void mai(String[] args) {
        String data = "ICU4J 是IBM的国际化开发组件ICU的Java语言实现版本。";
        String encode = getEncode(data);
        System.out.println("encode:" + encode);
    }

    public static String getEncode(String data) {
        return getEncode(data.getBytes());
    }
    public static String getEncode(byte[] data) {
        CharsetDetector detector = new CharsetDetector();
        detector.setText(data);
        CharsetMatch match = detector.detect();
        //取Confidence值最大的
        String encoding = match.getName();
        System.out.println("The Content in " + match.getName());
        CharsetMatch[] matches = detector.detectAll();
        System.out.println("All possibilities");
        for (CharsetMatch m : matches) {
            System.out.println("CharsetName:" + m.getName() + " Confidence:"
                    + m.getConfidence());
        }
        return encoding;
    }

    public static String getEncode(InputStream data)
            throws IOException {
        CharsetDetector detector = new CharsetDetector();
        detector.setText(data);
        CharsetMatch match = detector.detect();
        String encoding = match.getName();
        System.out.println("The Content in " + match.getName());
        CharsetMatch[] matches = detector.detectAll();
        System.out.println("All possibilities");
        for (CharsetMatch m : matches) {
            System.out.println("CharsetName:" + m.getName() + " Confidence:"
                    + m.getConfidence());
        }
        return encoding;
    }
}
