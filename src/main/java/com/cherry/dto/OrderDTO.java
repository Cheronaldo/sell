package com.cherry.dto;

import com.cherry.dataobject.OrderDetail;
import com.cherry.enums.OrderStatusEnum;
import com.cherry.enums.PayStatusEnum;
import com.cherry.utils.EnumUtil;
import com.cherry.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/09/28.
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    //dto : 数据传输对象  用于服务层（service）的数据传输  主要是用于项目内部各层的数据传输  如 service层和controller层的数据传输交互
    // 应用场景，服务层处理的数据对象，与控制层处理的数据对象属性密切相关但不完全相同的情况

    private String orderId;
    //买家名字
    private String buyerName;
    //买家电话
    private String buyerPhone;
    //买家地址
    private String buyerAddress;
    //买家openid
    private String buyerOpenid;
    //订单总额
    private BigDecimal orderAmount;
    //订单状态  默认为0新下单
    private Integer orderStatus;
    //支付状态  默认为0未支付
    private Integer payStatus;


    //为什么每次加上这两个字段 项目会启动不了？？？
    //创建时间  并将时间格式转换 使用注解和格式转换方法
    // @JsonSerialize(using = Date2LongSerializer.class)
//    private Data creteTime;
//    //更新时间
    // @JsonSerialize(using = Date2LongSerializer.class)
//    private Data updateTime;

    //一条主订单可能包含多条订单详情

    // 可以通过设置初始值避免为空 适用于数据内容为空，但是又必须回传的字段（一般给前端的时候会将为空的字段进行设置，对其不进行上传）
    //List<OrderDetail> orderDetailList = new ArrayList<>();

    List<OrderDetail> orderDetailList;

    //此注释的作用是 返回OrderDTO对象的Json数据的时候，会忽略返回这个函数的值
    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }

    public OrderDTO(){}

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerOpenid() {
        return buyerOpenid;
    }

    public void setBuyerOpenid(String buyerOpenid) {
        this.buyerOpenid = buyerOpenid;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
