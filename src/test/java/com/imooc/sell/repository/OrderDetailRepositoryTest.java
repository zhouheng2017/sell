package com.imooc.sell.repository;

import com.imooc.sell.SellApplicationTests;
import com.imooc.sell.dataobject.OrderDetail;
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
 * @Time: 14:46
 */
@Slf4j
public class OrderDetailRepositoryTest extends SellApplicationTests {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void testSave() {
        OrderDetail orderDetail = OrderDetail.builder()
                .orderId("11112")
                .detailId("detialId2")
                .productIcon("www.baidu.com")
                .productId("productId")
                .productName("name2")
                .productQuantity(20)
                .productPrice(new BigDecimal(3.8))
                .build();
        repository.save(orderDetail);
    }


    @Test
    public void findByOrderId() {
        List<OrderDetail> byOrderId = repository.findByOrderId("11111");
        System.out.println(byOrderId);

    }
}