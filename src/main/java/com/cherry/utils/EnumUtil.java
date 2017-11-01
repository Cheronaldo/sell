package com.cherry.utils;

import com.cherry.enums.CodeEnum;
import com.cherry.enums.OrderStatusEnum;

/**
 * 对于所有可以通过code 获取到信息 的enum类  提供一个通用方法
 * Created by Administrator on 2017/10/12.
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for(T each:enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
