package com.imooc.sell.service;

import com.imooc.sell.SellApplicationTests;
import com.imooc.sell.dataobject.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import sun.rmi.runtime.Log;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-14
 * @Time: 9:28
 */
@Slf4j
public class ProductServiceTest extends SellApplicationTests {
    @Autowired
    private ProductService productService;

    @Test
    public void findByCategoryType() {
        List<ProductInfo> byCategoryType = productService.findByCategoryType(1);
        Assert.assertNotNull(byCategoryType);
        log.info("byCategoryType {}", byCategoryType);

    }

    @Test
    public void findUpAll() {
        PageRequest pageRequest = new PageRequest(0, 2);

        List<ProductInfo> upAll = productService.findUpAll();
        log.info("upAll {}", upAll);

    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0, 2);

        Page<ProductInfo> all = productService.findAll(pageRequest);
        log.error("upAll {}", all);

    }
}