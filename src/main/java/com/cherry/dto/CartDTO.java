package com.cherry.dto;

import lombok.Data;

/**
 * 购物车  买家下订单后 前端传过来的数据 同样进行数据转换 给service层使用
 * 用于实现库存的相关操作
 * Created by Administrator on 2017/09/29.
 */
@Data
public class CartDTO {

    //商品id
    private String productId;

    //商品数量
    private Integer productQuantity;

    //字段较少的时候 给一个构造方法
    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}
