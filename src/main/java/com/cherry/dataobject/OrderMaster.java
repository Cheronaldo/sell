package com.cherry.dataobject;

import com.cherry.enums.OrderStatusEnum;
import com.cherry.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/09/28.
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    //订单ID
    @Id
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
    //订单状态  默认为新下单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    //支付状态  默认为未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();


    //为什么每次加上这两个字段 项目会启动不了？？？  因为之前设置的是 lombok.Data 类型  应该是 java.util.Date类型
//    private Data creteTime;!!!!!!!!!
//    private Data updateTime;

    //创建时间
   // private Date creteTime;
//    //更新时间
   // private Date updateTime;

    public OrderMaster(){}


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

//    public Date getCreteTime() {
//        return creteTime;
//    }
//
//    public void setCreteTime(Date creteTime) {
//        this.creteTime = creteTime;
//    }
//
//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }
}
