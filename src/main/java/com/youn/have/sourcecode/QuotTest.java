package com.youn.have.sourcecode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @Author：YangJx
 * @Description：字符串引号json解析测试
 * @DateTime：2018/1/15 16:08
 */
public class QuotTest {

    public static void objectToJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        Good good = new Good();
        good.setName("'样'");

        try {
            System.out.println(objectMapper.writeValueAsString(good));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void jsonToObject() {
        ObjectMapper objectMapper = new ObjectMapper();
        String kk = "你好，世界！\"我是\"";
        String jsonString = "{\"id\": \"longId\", \"name\": \"\'yang\'\"}";
        try {
            Good jsonpObject = objectMapper.readValue(jsonString, Good.class);
            System.out.println(jsonpObject.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getRuntimeMetrics() {
        System.out.println("当前JVM参数如下：");
        System.out.println("CPU数：" + Runtime.getRuntime().availableProcessors());
        System.out.println("最大内存：" + Runtime.getRuntime().maxMemory() / 1024 / 1024);
        System.out.println("空闲内存：" + Runtime.getRuntime().freeMemory() / 1024 / 1024);
        System.out.println("总内存：" + Runtime.getRuntime().totalMemory() / 1024 / 1024);
    }


    public static void main(String[] args) {
//        objectToJson();
        getRuntimeMetrics();
    }

}

class Good {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
