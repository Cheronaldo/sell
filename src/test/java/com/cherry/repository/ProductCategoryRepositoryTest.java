package com.cherry.repository;

import com.cherry.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/09/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = productCategoryRepository.findOne(1);
        //System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    //此注解是测试回滚，测试成功后会删除此记录  与service中的Transactional注解不同
    public void addTest(){
        ProductCategory productCategory = new ProductCategory("男生最爱",1);
//        productCategory.setCategoryName("女生最爱");
//        productCategory.setCategoryType(6);
       /// productCategoryRepository.save(productCategory);

        ProductCategory result = productCategoryRepository.save(productCategory);
        Assert.assertNotNull(result);
        //Assert.assertNotEquals(null,result);

    }

    @Test
    @Transactional
    public void updateTest(){
        ProductCategory productCategory = productCategoryRepository.findOne(2);
        //productCategory.setCategoryType(5);
        productCategoryRepository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2,3,4,5,6);

        List<ProductCategory> result = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }

}