package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-13
 * @Time: 15:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductInfoServiceTest {
    @Autowired
    private ProductService productInfoService;

    @Test
    public void findByCategoryType() {
        List<ProductInfo> byCategoryType = productInfoService.findByCategoryType(2);

        log.info("结果为：{}", byCategoryType);

    }

    @Test
    public void findAll() {
        org.springframework.data.domain.Pageable pageable = new PageRequest(1, 2);
        Page<ProductInfo> all = productInfoService.findAll(pageable);

        log.error("结果为：{}", all.getContent());

    }


    @Test
    public void saveProduct() {
        ProductInfo productInfo = ProductInfo.builder().productId("123456").productName("皮蛋粥")
                .productPrice(new BigDecimal(1.2))
                .productDescription("好吃的皮蛋粥")
                .categoryType(1)
                .productStock(30)

                .productIcon("https://www.baidu.com").build();

        productInfoService.save(productInfo);
        productInfo = ProductInfo.builder().productId("123457").productName("慕斯蛋糕")
                .productPrice(new BigDecimal(10.9))
                .productDescription("美味爽口")
                .categoryType(2)
                .productStock(30)
                .productIcon("https://www.baidu.com").build();
        productInfoService.save(productInfo);

    }
}