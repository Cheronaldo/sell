package com.cherry.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 进行表单验证（前后端数据参数验证）
 * Created by Administrator on 2017/09/30.
 */
@Data
public class OrderForm {

    //买家姓名
    @NotEmpty(message = "买家姓名必填")
    private String name;

    //买家手机号
    @NotEmpty(message = "买家手机号必填")
    private String phone;

    //买家地址
    @NotEmpty(message = "买家地址必填")
    private String address;

    //买家微信openid
    @NotEmpty(message = "买家微信openid必填")
    private String openid;

    //购物车列表 以json格式的字符串下发
    @NotEmpty(message = "购物车不为空")
    private String items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
