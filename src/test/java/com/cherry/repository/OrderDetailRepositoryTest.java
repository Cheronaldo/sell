package com.cherry.repository;

import com.cherry.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/09/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456238");
        orderDetail.setOrderId("1111113");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("1234532");
        orderDetail.setProductName("热干面");
        orderDetail.setProductPrice(new BigDecimal(4.5));
        orderDetail.setProductQuantity(3);

        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() throws Exception {

        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId("1111111");
        Assert.assertNotEquals(0,orderDetailList.size());

    }

}