package com.cherry.service;

import com.cherry.dataobject.ProductCategory;

import java.util.List;

/**
 *类目
 * Created by Administrator on 2017/09/23.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    //提供给买家端查询   买家用于查看所有上架商品类目  （其余3个是卖家管理接口）
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
