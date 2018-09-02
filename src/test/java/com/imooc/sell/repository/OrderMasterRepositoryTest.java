package com.imooc.sell.repository;

import com.imooc.sell.SellApplicationTests;
import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-14
 * @Time: 9:42
 */
@Slf4j
public class OrderMasterRepositoryTest extends SellApplicationTests {
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = new PageRequest(0, 1);

        Page<OrderMaster> openid = orderMasterRepository.findByBuyerOpenid("openid", pageRequest);

        log.error("{}", openid);

    }
    @Test
    public void save() {
        OrderMaster orderMaster = OrderMaster.builder()
                .orderAmount(new BigDecimal(100))
                .orderId("123")
                .orderStatus(OrderStatusEnum.NEW.getCode())
                .buyerAddress("address")
                .buyerName("buysername")
                .buyerOpenid("openid")
                .buyerPhone("16789887667")
                .payStatus(PayStatusEnum.WAIT.getCode())
                .build();
        OrderMaster save = orderMasterRepository.save(orderMaster);
        log.error("{}", save);
        Assert.assertNotNull(save);

    }


}