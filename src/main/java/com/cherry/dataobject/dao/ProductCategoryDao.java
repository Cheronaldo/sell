package com.cherry.dataobject.dao;

import com.cherry.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by Administrator on 2017/10/16.
 */
public class ProductCategoryDao {

    @Autowired
    ProductCategoryMapper mapper;

    //dao层的方法名最好与对应mapper接口中函数名保存一致，也可以不一样
    public int insertByMap(Map<String, Object> map) {
        return mapper.insertByMap(map);
    }

}
