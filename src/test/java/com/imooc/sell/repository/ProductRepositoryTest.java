package com.imooc.sell.repository;

import com.imooc.sell.SellApplicationTests;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ProductStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-14
 * @Time: 9:17
 */
@Slf4j
public class ProductRepositoryTest extends SellApplicationTests {

    @Autowired
    private ProductRepository productRepository;


    @Test
    public void findByCategoryType() {
        List<ProductInfo> byCategoryType = productRepository.findByCategoryType(1);
        log.info("产品的信息为， {}", byCategoryType);


    }

    @Test
    public void findByStatus() {
        List<ProductInfo> byStatus = productRepository.findByStatus(ProductStatusEnum.UP.getCode());

        log.info("byStatus :{}", byStatus);

    }

    @Test
    public void save() {
        ProductInfo productInfo = ProductInfo.builder().productIcon("www.baidu.com")
                .productId("12345678")
                .productDescription("产品很好吃")
                .productPrice(new BigDecimal(3.4))
                .productStock(300)
                .status(0)
                .productName("好吃的产品")
                .categoryType(3)
                .build();

        ProductInfo save = productRepository.save(productInfo);
        log.info("ProductIndo {}", save);

    }
}