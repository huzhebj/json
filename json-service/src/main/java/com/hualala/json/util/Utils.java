package com.hualala.json.util;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Utils {

    public static <T> Object transformJsonToBean(String json, Class<T> type) {
        JSONObject jsonObject = JSONObject.fromObject(json);
        return JSONObject.toBean(jsonObject, type);
    }

    public static <T> Object transformJsonToBeanList(String jsonArr,Class<T> type) {
        JSONArray jsonArray = JSONArray.fromObject(jsonArr);
        return JSONArray.toCollection(jsonArray, type);
    }

}
