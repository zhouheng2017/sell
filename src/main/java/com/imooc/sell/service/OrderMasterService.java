package com.imooc.sell.service;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dataobject.OrderMaster;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-15
 * @Time: 15:16
 */
public interface OrderMasterService extends BaseService<OrderMaster> {
    List<OrderMaster> findByOrderId(String orderId);
}
