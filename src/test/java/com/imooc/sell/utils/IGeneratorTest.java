package com.imooc.sell.utils;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.dto.OrderDetail2;
import com.imooc.sell.service.OrderDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-15
 * @Time: 13:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IGeneratorTest {
    @Autowired
    private IGenerator generator;

    @Autowired
    private OrderDetailService orderDetailService;

    @Test
    public void convert() {

        OrderDetail one = orderDetailService.findOne("1534258807681705790");

        one.setOrderId(null);
        one.setProductName(null);

        OrderDetail2 convert = new OrderDetail2();
        convert.setOrderId("Orda");
        System.out.println(convert);

        convert = generator.convert(one, convert);
        System.out.println(convert);

    }

    @Test
    public void convert1() {
    }

    @Test
    public void convert2() {
    }

    @Test
    public void convert3() {
    }

    @Test
    public void convert4() {
    }
}