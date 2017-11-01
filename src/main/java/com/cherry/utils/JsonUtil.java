package com.cherry.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Json数据格式化
 * Created by Administrator on 2017/10/08.
 */
public class JsonUtil {

    public static String toJson (Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }

}
