package com.cherry.dataobject.mapper;


import com.cherry.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/16.
 */
public interface ProductCategoryMapper {

    //通过map插入  sql语句中的参数名要与map的键名一致
    @Insert("insert into product_category(category_name,category_type) values(#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByMap(Map<String,Object> map);

    //通过对象插入（更普遍） sql语句中的参数名要与对应的数据对象的属性名一致
    @Insert("insert into product_category(category_name,category_type) values(#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);

    //通过categoryType查找  需建立返回的变量参数(名称与对应的数据对象属性名一致)与数据库字段的映射，
    // 可以只建立需要返回参数的映射（最好是都建立，除创建时间和更新时间两个字段外）
    @Select("select * from product_category where category_type = #{categoryType}")
    @Results({
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_type",property = "categoryType")

    })
    ProductCategory findByCategoryType(Integer categoryType);

    //通过categoryName查找  因为查找时要返回数据对象，所以需要将数据库字段与数据对象的属性变量关联
    // 即建立变量参数与数据库字段的映射  #{categoryName} 里面的变量就是函数传入的变量
    @Select("select * from product_category where category_name = #{categoryName}")
    @Results({
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_type",property = "categoryType")

    })
    List<ProductCategory> findByCategoryName(String categoryName);

    //通过某个字段更新    传入多个变量时 需加上  @Param 注解
    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    //int updateByCategoryType(String categoryName,Integer categoryType);
    int updateByCategoryType(@Param("categoryName") String categoryName,
                             @Param("categoryType") Integer categoryType);

    //通过传入对象的某个字段更新 （即通过对象更新）   传入多个变量时 需加上  @Param 注解
    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByObject(ProductCategory productCategory);

    //通过categoryType删除
    @Delete("delete from product_category where category_type = #{categoryType}")
    int deleteByCategoryType(Integer categoryType);


    //通过mybatis的配置方式查询
    ProductCategory selectByCategoryType(Integer categoryType);

}
