package com.imooc.sell.controller;

import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.service.OrderService;
import com.imooc.sell.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-01
 * @Time: 13:27
 */
@Controller
@Slf4j
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;


    @RequestMapping("/create")
    public String create(@RequestParam("openId") String openId) {
        OrderDTO orderDTO = orderService.findOne(openId);
        if (!ObjectUtils.allNotNull(orderDTO)) {
            log.error("orderDTO 为空");
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //对订单进行支付
        PayResponse payResponse = payService.create(orderDTO);


        return "";

    }
}
