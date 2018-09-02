package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-14
 * @Time: 10:19
 */
public interface PayService {

    /**
     * 创建支付
     *
     * @param orderDTO
     * @return
     */
    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundRequest refund(OrderDTO orderDTO);

}
