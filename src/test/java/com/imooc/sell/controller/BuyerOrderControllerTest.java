package com.imooc.sell.controller;

import com.imooc.sell.SellApplicationTests;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.service.BuyerService;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-15
 * @Time: 17:11
 */
@AutoConfigureMockMvc
public class BuyerOrderControllerTest extends SellApplicationTests {
    public static final String OPENIDZHOUHENG = "openidzhouheng";
    public static final String ORDER_ID = "1534258807456994883";

    @Autowired
    private MockMvc mock;
    @Autowired
    private BuyerService buyerService;

    @Test
    public void create() {

        OrderDTO orderOne = buyerService.findOrderOne(OPENIDZHOUHENG, ORDER_ID);



//        mock.perform(MockMvcRequestBuilders.post("/buyer/order/create").requestAttr(orderOne));
    }
}