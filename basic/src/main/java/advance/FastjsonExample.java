package advance;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @PackageName advance
 * @Author joel
 * @Date 2018/12/26 12:10
 **/
public class FastjsonExample {
    public static void simpleExample() {
        // Alibaba fastjson
        int[] ints1 = {1, 2, 3};
        System.out.println(Arrays.toString(ints1));
        String intsjson = JSON.toJSONString(ints1);
        int[] ints2 = JSON.parseObject(intsjson, int[].class);

        System.out.println(intsjson);
        System.out.println(ints2.length);
        System.out.println("=====");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "中文");
        jsonObject.put("age", 50);
        jsonObject.put("salary", new BigDecimal(8000));
        String text = JSON.toJSONString(jsonObject, SerializerFeature.BrowserCompatible);

    }

    public static void main(String[] args) {
        simpleExample();
    }
}
