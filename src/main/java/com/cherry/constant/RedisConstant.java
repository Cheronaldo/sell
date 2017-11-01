package com.cherry.constant;

/**
 * redis常量
 * Created by Administrator on 2017/10/15.
 */
public interface RedisConstant {

    //设置token 储存的key 的头 为 token_
    String TOKEN_PREFIX = "token_%s";

    Integer EXPIRE = 7200;// 设置过期时间为2小时 使用redis的时候一定要设置过期时间

}
