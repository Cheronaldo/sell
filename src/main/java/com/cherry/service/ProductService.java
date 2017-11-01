package com.cherry.service;

import com.cherry.dataobject.ProductInfo;
import com.cherry.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;

/**
 * Created by Administrator on 2017/09/24.
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 分页查询所有商品 要返回page对象 而不是list
     * @param pageable
     * @return
     */
//    List<ProductInfo> findAll(Pageable pageable);
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);
}
