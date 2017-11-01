package com.cherry.controller;

import com.cherry.dataobject.ProductCategory;
import com.cherry.exception.SellException;
import com.cherry.form.CategoryForm;
import com.cherry.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 卖家类目
 * Created by Administrator on 2017/10/14.
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;

    //如果要对类目进行删除操作，需先查找该类目中是否存在商品，再进行处理


    /**
     * 类目列表
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String,Object> map){
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("category/list",map);
    }

    /**
     * 具体展示界面
     * @param categoryId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                              Map<String,Object> map){

        //新增的时候 categoryId 为 null  查询null的时候处理要谨慎 很多判断条件在查询null的时候会抛异常
        //如 if(categoryId > 0 ) ，当 新增的时候 categoryId 为 null，此时就会抛异常
        if(categoryId != null){
            ProductCategory productCategory = categoryService.findOne(categoryId);
            map.put("category",productCategory);
        }

        return new ModelAndView("category/index",map);

    }

    /**
     * 保存/更新
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map){

        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/category/index");
            return new ModelAndView("common/error",map);
        }

        ProductCategory productCategory = new ProductCategory();
        try{
            if(form.getCategoryId() != null){
                productCategory = categoryService.findOne(form.getCategoryId());
            }
            BeanUtils.copyProperties(form,productCategory);
            //由于categoryId 是自增的，所以新增时不需要设置categoryId的值
            categoryService.save(productCategory);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/category/index");
            return new ModelAndView("common/error",map);
        }

        map.put("url","/sell/seller/category/list");
        return new ModelAndView("common/success",map);
    }

}
