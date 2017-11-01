package com.cherry.controller;

import com.cherry.VO.ProductInfoVO;
import com.cherry.VO.ProductVO;
import com.cherry.VO.ResultVO;
import com.cherry.dataobject.ProductCategory;
import com.cherry.dataobject.ProductInfo;
import com.cherry.service.CategoryService;
import com.cherry.service.ProductService;
import com.cherry.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * Created by Administrator on 2017/09/25.
 */
//@RestController 表名返回的数据格式为 json  路径尽量与类名保持一致
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    //动态设置 key值为方法参数值 ；以及通过condition对key值的判断 来确定是否执行（储存到）缓存；result为返回的对象，unless：如果不的意思，当返回对象的code是0（数据正确）的时候才执行（储存到）缓存
//    @Cacheable(cacheNames = "product",key = "#sellerId",condition = "#sellerId.length() > 3"，unless = "#result.getCode() != 0")
//        public ResultVO list(@RequestParam("sellerId") String sellerId){

    @GetMapping("/list")
    @Cacheable(cacheNames = "product",key = "123")
    public ResultVO list(){

        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.查询类目（一次性查询）

        //List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
//        for(ProductInfo productInfo : productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }

        //精简方法（Java8 lambda）  转成stream->获取要的属性值->收集成list
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装  不要把数据库的查询放到for循环中去
        //按照定义的数据格式，从内层往外逐渐添加  productInfoVO-->productVO-->ResultVO
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());


            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){

                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);//////

        }



//        ResultVO resultVO = new ResultVO();
//        ProductVO productVO = new ProductVO();
//        ProductInfoVO productInfoVO = new ProductInfoVO();


//        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
//        resultVO.setData(Arrays.asList(productVO));

//        resultVO.setData(productVOList);
//        resultVO.setCode(0);
//        resultVO.setMsg("成功");
//
//        return  resultVO;


        return ResultVOUtil.success(productVOList);

    }


}
