package advance;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GsonExample {
    public static void simpleExample() {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();

        // Array [1,2,3]
        int[] ints1 = {1, 2, 3};
        String intsjson = gson.toJson(ints1);
        int[] ints2 = gson.fromJson(intsjson, int[].class);
        System.out.println(intsjson);
        System.out.println(ints2.length);

        // String Array ["1","2","3"]
        String[] strings1 = {"1", "2", "3"};
        String stringsjson = gson.toJson(strings1);
        String[] strings2 = gson.fromJson(stringsjson, String[].class);
        System.out.println(stringsjson);
        System.out.println(strings2.length);
        System.out.println("=====");

        // Collection {"k1":"v1","k2":"v2","k3":"v3"}
        HashMap<String, String> hm = new HashMap<>();
        hm.put("k1", "中文");
        hm.put("k2", "v2");
        hm.put("k3", "v3");
        String hmjson = gson.toJson(hm);
        System.out.println(hmjson);
        // decode
        Type collectionType = new TypeToken<HashMap<String, String>>() {}.getType();
        HashMap<String, String> jsonhm = gson.fromJson(hmjson, collectionType);
        for (Map.Entry<String, String> j : jsonhm.entrySet()) {
            System.out.println(j.getKey() + " : " + j.getValue());
        }
        System.out.println("=====");

        // Collection [1,"2",{"name":"zhang","age":10},{"name":"li","age":11}]
        // 并不建议,也就是用Gson 来处理比较麻烦
        @SuppressWarnings("rawtypes")
        Collection collection = new ArrayList();
        collection.add(1);
        collection.add("2");
        collection.add(new User("ying", 21));
        collection.add(new User("yang", 20));
        String jsonCollection = gson.toJson(collection);
        System.out.println(jsonCollection);

        // decode id difficult
        JsonArray jsonArray = parser.parse(jsonCollection).getAsJsonArray();
        int one = jsonArray.get(0).getAsInt();
        String two = jsonArray.get(1).getAsString();
        JsonObject jo1 = jsonArray.get(2).getAsJsonObject();
        JsonObject jo2 = jsonArray.get(3).getAsJsonObject();
        User user1 = gson.fromJson(jo1, User.class);
        User user2 = gson.fromJson(jo2, User.class);
        System.out.println(one);
        System.out.println(two);
        System.out.println("name: " + user1.getName() + ", age: " + user1.getAge());
        System.out.println("name: " + user2.getName() + ", age: " + user2.getAge());
        System.out.println("===== simple example =====");
    }

    public static void jsonDecode() {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();

        String json1 = "[1,2,3]";
        int[] ints = gson.fromJson(json1, int[].class);
        System.out.println(json1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        JsonArray jsonArray1 = parser.parse(json1).getAsJsonArray();
        int one1 = gson.fromJson(jsonArray1.get(0), int.class);
        int two1 = gson.fromJson(jsonArray1.get(1), int.class);
        int three1 = gson.fromJson(jsonArray1.get(2), int.class);
        System.out.println(one1 + ", " + two1 + ", " + three1);
        System.out.println("=====");

        String json2 = "[1,\"2\"]";
        JsonArray jsonArray2 = parser.parse(json2).getAsJsonArray();
        int one2 = gson.fromJson(jsonArray2, int.class);
        String two2 = gson.fromJson(jsonArray2, String.class);
        int one3 = jsonArray2.get(0).getAsInt();
        String two3 = jsonArray2.get(1).getAsString();
        System.out.println(json2);
        System.out.println(one2 + ", " + two2);
        System.out.println(one3 + ", " + two3);
        System.out.println("=====");


        System.out.println("===== jsonDecode =====");
    }

    public static void main(String[] args) {
        simpleExample();
        jsonDecode();
    }
}
