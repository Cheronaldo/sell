package com.cherry.enums;

/**
 * 对于所有可以通过code 获取到信息 的enum类  提供一个通用方法（定义一个接口 然后逐个去继承实现）
 * Created by Administrator on 2017/10/12.
 */
public interface CodeEnum {
    Integer getCode();
}
