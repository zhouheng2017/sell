package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.repository.ProductCategoryRepository;
import com.imooc.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-10
 * @Time: 10:34
 */
@Service
public class categoryServiceImpl extends BaseServiceImpl<ProductCategory> implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    protected JpaRepository getDaoClass() {
        return productCategoryRepository;
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes) {
        List<ProductCategory> byCategoryTypeIn = productCategoryRepository.findByCategoryTypeIn(categoryTypes);
        return byCategoryTypeIn;
    }
}
