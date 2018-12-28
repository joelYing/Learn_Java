package com.advance;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * @PackageName advance
 * @Author joel
 * @Date 2018/12/26 12:10
 **/
public class FastjsonExample {
    public static void simpleExample() {
        // Alibaba fastjson
        // JSON.toJSONString(xxx) -> JSON.parseObject(xxx, xxx类型.class)
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
        // BrowserCompatible 将中文都会序列化为\\uXXXX格式，字节数会多一些，但是能兼容IE 6，默认为false
        String text = JSON.toJSONString(jsonObject, SerializerFeature.BrowserCompatible);
        System.out.println(text);
        JSONObject jo = JSON.parseObject(text, JSONObject.class);
        for (Entry<String, Object> j : jo.entrySet()) {
            System.out.println(j.getKey() + " : " + j.getValue());
        }
        System.out.println("=====");

        // [1, "2"]
        JSONArray ja1 = new JSONArray();
        ja1.add(1);
        ja1.add("2");
        String json = JSON.toJSONString(ja1);
        System.out.println(json);

        JSONArray pja1 = JSON.parseArray(json);
        for (Object object : pja1) {
            System.out.println(object);
        }
        System.out.println("=====");

        // 对于 [1,"2",{"age":10,"name":"zhang"},{"age":11,"name":"li"}]
        // fastjson 能很好的处理，不用额外的class
        JSONArray ja2 = new JSONArray();
        JSONObject jo2 = new JSONObject();
        JSONObject jo3 = new JSONObject();
        jo2.put("name", "ying");
        jo2.put("age", 21);
        jo3.put("name", "yang");
        jo3.put("age", 20);
        ja2.add(1);
        ja2.add("2");
        ja2.add(jo2);
        ja2.add(jo3);
        String jsonArr = JSON.toJSONString(ja2);
        System.out.println(jsonArr);

        JSONArray pja2 = JSON.parseArray(jsonArr);
        int one = (int) pja2.get(0);
        String two = (String) pja2.get(1);
        JSONObject o1 = (JSONObject) pja2.get(2);
        JSONObject o2 = (JSONObject) pja2.get(3);
        System.out.println(one);
        System.out.println(two);
        for (Entry<String, Object> o : o1.entrySet()) {
            System.out.println(o.getKey() + " : " + o.getValue());
        }
        for (Entry<String, Object> o : o2.entrySet()) {
            System.out.println(o.getKey() + " : " + o.getValue());
        }
        System.out.println("===== Simple Fastjson =====");
    }

    public static void jsonObject() {
        // encode
        Response response = new Response();
        response.setCode(200);
        response.setMsg("ok");

        HashMap<String, String> data1 = new HashMap<>();
        data1.put("key", "中文");
        response.setData1(data1);

        ResponseData rd1 = new ResponseData();
        ResponseData rd2 = new ResponseData();
        rd1.setB(true);
        rd1.setI(1);
        rd1.setN(null);
        rd1.setS("string1");
        rd2.setI(2);
        rd2.setS("string2");
        rd2.setN(null);
        rd2.setB(false);
        response.addData2(rd1);
        response.addData2(rd2);

        // 处理null值， 编码中文
        String json = JSON.toJSONString(response, SerializerFeature.BrowserCompatible,
                SerializerFeature.WriteMapNullValue);
        System.out.println(json);
        System.out.println("=====");

        // Fastjson 解析object 不能是内部class 否则会出现解析异常
        Response responseJson = JSON.parseObject(json, Response.class);
        int code = responseJson.getCode();
        String msg = responseJson.getMsg();
        HashMap<String, String> data3 = responseJson.getData1();
        List<ResponseData> data4 = responseJson.getData2();
        System.out.println("code : " + code);
        System.out.println("msg : " + msg);
        for (Entry<String, String> d : data3.entrySet()) {
            System.out.println(d.getKey() + " : " + d.getValue());
        }
        for (ResponseData d : data4) {
            System.out.println("s: " + d.getS() + ", i: " + d.getI() + ", b: " + d.isB());
            System.out.println(d.getN() == null ? "yes" : "no");
        }
    }

    public static void main(String[] args) {
//        simpleExample();
//        jsonObject();
    }
}
