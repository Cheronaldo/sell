package com.cherry.form;

import lombok.Data;

/**
 * Created by Administrator on 2017/10/14.
 */
@Data
public class CategoryForm {

    private Integer categoryId;//类目ID

    private String categoryName;//类目名字
    private Integer categoryType;//类目编号

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
}
