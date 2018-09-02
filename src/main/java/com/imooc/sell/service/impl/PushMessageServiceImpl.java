package com.imooc.sell.service.impl;

import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.service.PushMessageService;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-14
 * @Time: 10:25
 */
@Service
public class PushMessageServiceImpl implements PushMessageService {
//    @Autowired
//    private WxMpService wxMpService;


    /**
     * 订单状态变更消息
     *
     * @param orderDTO
     */
    @Override
    public void orderStatus(OrderDTO orderDTO) {

    }
}
