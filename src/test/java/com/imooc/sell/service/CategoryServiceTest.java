package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-10
 * @Time: 11:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() {
        ProductCategory one = categoryService.findOne(1);

        log.info("{}", one);

        Pageable pageable = new PageRequest(0, 1);

        Page<ProductCategory> all = categoryService.findAll(pageable);

        log.info("{}", all.getContent());

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(5);
        productCategory.setCategoryType(5);
        productCategory.setCategoryName("Name");
        categoryService.save(productCategory);

    }
}