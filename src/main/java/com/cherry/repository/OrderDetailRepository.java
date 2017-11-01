package com.cherry.repository;

import com.cherry.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/09/28.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String>{

    //通过订单ID 来查询 一条主订单可能有多条订单详情
    List<OrderDetail> findByOrderId(String orderId);

}
