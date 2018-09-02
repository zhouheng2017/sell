package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.repository.OrderMasterRepository;
import com.imooc.sell.service.BaseService;
import com.imooc.sell.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-15
 * @Time: 15:16
 */
@Service
public class OrderMasterServiceImpl extends BaseServiceImpl<OrderMaster> implements OrderMasterService {
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Override
    protected JpaRepository getDaoClass() {
        return orderMasterRepository;
    }

    @Override
    public List<OrderMaster> findByOrderId(String orderId) {
        return orderMasterRepository.findByOrderId(orderId);
    }

}
