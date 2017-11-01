package com.cherry.repository;

import com.cherry.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/10/14.
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String>{

    //通过openid查询信息
    SellerInfo findSellerInfoByOpenid(String openid);

}
