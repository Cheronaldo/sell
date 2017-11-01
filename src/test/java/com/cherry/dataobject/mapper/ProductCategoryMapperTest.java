package com.cherry.dataobject.mapper;

import com.cherry.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/10/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() throws Exception {

        Map<String,Object> map = new HashMap<>();
        map.put("categoryName","儿童最爱");
        map.put("categoryType",6);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1,result);

    }

    @Test
    public void insertByObject() throws Exception {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("学生最不爱");
        productCategory.setCategoryType(7);
        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1,result);

    }

    @Test
    public void findByCategoryType(){

        ProductCategory result = mapper.findByCategoryType(2);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByCategoryName(){
        List<ProductCategory> result = mapper.findByCategoryName("女生最爱");
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void updateByCategoryType (){
        int result = mapper.updateByCategoryType("老年人最爱",8);
        Assert.assertEquals(1,result);
    }


    @Test
    public void updateByObject (){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("学生最爱");
        productCategory.setCategoryType(7);
        int result = mapper.updateByObject(productCategory);
        Assert.assertEquals(1,result);
    }

    @Test
    public void deleteByCategoryType(){
        int result = mapper.deleteByCategoryType(8);
        Assert.assertEquals(1,result);
    }

    @Test
    public void selectByCategoryType(){
        ProductCategory result = mapper.selectByCategoryType(7);
        Assert.assertNotNull(result);
    }

}