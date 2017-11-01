package com.cherry.dataobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

/**
 * 商品类目
 * Created by Administrator on 2017/09/20.
 */
@Entity
@DynamicUpdate
@Data
//添加lombok插件后，使用@Data注解可以省去实体类中的 get set方法 已经tostring方法
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;//类目ID

    private String categoryName;//类目名字
    private Integer categoryType;//类目编号

//    private Date createTime;
//    private Date updateTime;

    public ProductCategory(){}

    public ProductCategory(String categoryName, Integer categoryType){
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }



    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }

    //    @Override
//    public String toString() {
//        return "ProductCategory{" +
//                "categoryId=" + categoryId +
//                ", categoryName='" + categoryName + '\'' +
//                ", categoryType=" + categoryType +
//                '}';
//    }
}
