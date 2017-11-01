package com.cherry.service;

import com.cherry.dto.OrderDTO;

/**
 * 买家
 * Created by Administrator on 2017/10/07.
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);

}
