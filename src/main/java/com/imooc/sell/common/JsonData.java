package com.imooc.sell.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-10
 * @Time: 14:30
 */
@Data
public class JsonData<T> {
    private Integer code;
    private String msg;
    private T data;

    public static JsonData success(Object object, String msg) {
        JsonData jsonData = new JsonData(0);
        jsonData.data = object;
        jsonData.msg = msg;
        return jsonData;
    }

    public static JsonData success(Object object) {
        JsonData jsonData = new JsonData(0);
        jsonData.data = object;
        return jsonData;
    }

    public static JsonData success() {
        JsonData jsonData = new JsonData(0);
        return jsonData;
    }

    public static JsonData fail(String msg) {

        JsonData jsonData = new JsonData(1);
        jsonData.msg = msg;
        return jsonData;

    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);

        return map;
    }

    public JsonData() {
    }

    public JsonData(Integer code) {

        this.code = code;
    }

}
