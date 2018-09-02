package com.imooc.sell.controller;

import com.google.common.collect.Lists;
import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductService;
import com.imooc.sell.utils.ResultVOUtil;
import com.imooc.sell.vo.ProductInfoVO;
import com.imooc.sell.vo.ProductVO;
import com.imooc.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-10
 * @Time: 14:51
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;


    @GetMapping("/list")
    public ResultVO list() {
        //查询所有的商品
        List<ProductInfo> productInfoList = productService.findUpAll();
//        根据商品获取所有的品类
        List<Integer> categoryTypeList = productInfoList.stream().map(productInfo -> productInfo.getCategoryType()).collect(Collectors.toList());


        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);


        //获取category类型的列表
        List<ProductVO> productVOList = Lists.newArrayList();
        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

//            List<ProductInfo> byCategoryType = productService.findByCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = Lists.newArrayList();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {

                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }

            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);

        }


        return ResultVOUtil.success(productVOList);
    }

}
