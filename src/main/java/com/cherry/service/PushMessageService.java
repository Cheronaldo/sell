package com.cherry.service;

import com.cherry.dto.OrderDTO;

/**
 * 消息推送
 * Created by Administrator on 2017/10/15.
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);

}
