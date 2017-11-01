package com.cherry.repository;

import com.cherry.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/09/20.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    //注意查找方法 通常以findBy开头来命名查找函数

}
