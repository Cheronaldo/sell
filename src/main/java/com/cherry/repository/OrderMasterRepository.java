package com.cherry.repository;

import com.cherry.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/09/28.
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    //通过买家openid来进行分页查询
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);


}
