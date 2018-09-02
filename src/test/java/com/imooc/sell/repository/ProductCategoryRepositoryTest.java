package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-09
 * @Time: 20:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void testFindOne() {

        ProductCategory one = productCategoryRepository.findOne(1);
        log.info(one.toString());
        List<ProductCategory> all = productCategoryRepository.findAll();
        log.info("list{}", all);

    }


    @Test
    @Transactional
    public void testSave() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(4);

        productCategory.setCategoryName("NameLikes");
        productCategory.setCategoryType(3);
        ProductCategory save = productCategoryRepository.save(productCategory);

    }

    @Test
    public void testFindByCategoryTypeIn() {
        List<Integer> categoryTypeList = Arrays.asList(2, 3, 4, 10);
        List<ProductCategory> productCategories = productCategoryRepository.findByCategoryTypeIn(categoryTypeList);

        log.info("productCategory: {}", productCategories);
    }



}