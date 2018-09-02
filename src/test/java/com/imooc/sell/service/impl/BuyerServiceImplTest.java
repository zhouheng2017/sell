package com.imooc.sell.service.impl;

import com.imooc.sell.SellApplicationTests;
import com.imooc.sell.dto.OrderDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-15
 * @Time: 15:41
 */
public class BuyerServiceImplTest extends SellApplicationTests {

    public static final String OPENIDZHOUHENG = "openidzhouheng";
    public static final String ORDER_ID = "1534258807456994883";
    @Autowired
    private BuyerServiceImpl buyerService;

    @Test
    public void findOrderOne() {
        OrderDTO openidzhouheng = buyerService.findOrderOne(OPENIDZHOUHENG, ORDER_ID);
        System.out.println(openidzhouheng);

    }

    @Test
    public void cancelOrder() {
        OrderDTO orderDTO = buyerService.cancelOrder(OPENIDZHOUHENG, ORDER_ID);
        System.out.println(orderDTO);

    }
}