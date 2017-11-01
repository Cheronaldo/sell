package com.cherry.repository;

import com.cherry.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

/**
 * Created by Administrator on 2017/09/24.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>{

    //查询商品状态
    List<ProductInfo> findByProductStatus(Integer productStatus);

}
