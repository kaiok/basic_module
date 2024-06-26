package com.kais.jsonObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kais
 * @date 2022.04.26. 19:18
 * 1.阿里巴巴提供的一个json快速转换工具类，实现了Map接口，通过Key Value形式存储数据，初始化大小为16，有参构造方法需要传入一个Map
 *
 * 2.用于Json转具体的Object实体类，或者String快速转JSON格式，都可以用
 *
 * 3.所需依赖
 *         <dependency>
 *             <groupId>com.alibaba</groupId>
 *             <artifactId>fastjson</artifactId>
 *             <version>2.0.1</version>
 *         </dependency>
 */
public class JSONObjectTest {

    public static void main(String[] args) {

        // 通过无参构造直接赋值
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id","215");
        jsonObject.put("name","kais");
        // json对象字符串:{"name":"kais","id":"215"}
        System.out.println("通过无参构造直接赋值" + jsonObject);

        System.out.println();
        System.out.println("=================");


        // 将JSONObject作为List参数
        ArrayList<JSONObject> arrayList = new ArrayList<JSONObject>();
        arrayList.add(jsonObject);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("id","111");
        jsonObject1.put("name","kafuka");

        arrayList.add(jsonObject1);
        // json数组对象：[{"name":"kais","id":"215"}, {"name":"kafuka","id":"111"}]
        System.out.println("将JSONObject作为List参数" + arrayList);
        System.out.println("=================");

        System.out.println();
        // JSON对象转为POJO:Person(id=215, name=kais)
        Person person = JSON.toJavaObject(jsonObject, Person.class);
        System.out.println("JSON对象转为POJO" + person);

        System.out.println("=================");

        // 将map集合作为参数，通过有参构造创建JSON对象
        HashMap<String, Object> map = new HashMap<String, Object>(2);
        map.put("id",333);
        map.put("name","kais");
        JSONObject jsonObject2 = new JSONObject(map);
        System.out.println("将map集合作为参数，通过有参构造创建JSON对象" + jsonObject2);

        System.out.println("=================");

        // String转为JSONObject对象
        String string = "{id:111,name:\"kkk\"}";
        JSONObject jsonObject3 = JSONObject.parseObject(string);
        System.out.println("String--->JSON" + jsonObject3);

        // json数组
        System.out.println("111111111111111111111111");
        Map<String, ArrayList<JSONObject>> hashMap = new HashMap<String,ArrayList<JSONObject>>();
        ArrayList<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        ArrayList<JSONObject> jsonObjects1 = new ArrayList<JSONObject>();
        jsonObjects.add(jsonObject);
        jsonObjects1.add(jsonObject1);
        hashMap.put("key1",jsonObjects);
        hashMap.put("key2",jsonObjects1);
        System.out.println(hashMap);





    }
}
