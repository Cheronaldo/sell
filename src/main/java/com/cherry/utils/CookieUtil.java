package com.cherry.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * cookie工具类
 * Created by Administrator on 2017/10/15.
 */
public class CookieUtil {

    /**
     * 设置cookie
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");//path一般不会修改 直接写死
        cookie.setMaxAge(7200);
        response.addCookie(cookie);
    }


    /**
     * 获取cookie  从request中获取cookie得到的是一个数组
     * @param request
     * @param name
     */
    public static Cookie get(HttpServletRequest request,
                           String name){

        Map<String,Cookie> cookieMap = readCookieMap(request);
        if(cookieMap.containsKey(name)){
            return cookieMap.get(name);
        }else {
            return null;
        }
    }

    /**
     * 将cookie封装成Map
     * @param request
     * @return
     */
    //将cookie数组转换为 map键值对的形式
    private static Map<String,Cookie> readCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(),cookie);
            }
        }

        return cookieMap;
    }

}



