package com.cherry.utils;

import java.util.Random;

/**
 * Created by Administrator on 2017/09/29.
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();

        Integer number = random.nextInt(900000)+100000;//生成6位随机数

        return System.currentTimeMillis() + String.valueOf(number);

        //考虑到多线程同步 还需做synchronized处理

    }

}
