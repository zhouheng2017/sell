package com.imooc.sell.service;

import com.google.common.collect.Lists;
import com.imooc.sell.SellApplicationTests;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-14
 * @Time: 22:33
 */
@Slf4j
@Transactional
public class OrderServiceTest extends SellApplicationTests {

    private final static String OPENID = "openidzhouheng";

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private OrderMasterService orderMasterService;


    @Test
    public void create() {

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName("zhouheng");
        orderDTO.setBuyerAddress("address");
        orderDTO.setBuyerOpenid(OPENID);
        orderDTO.setBuyerPhone("1322203322");
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123456");
        orderDetail.setProductQuantity(2);

        List<OrderDetail> orderDetailList = Lists.newArrayList();
        orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);

        orderService.create(orderDTO);
    }

    @Test
    public void findOne() {
        OrderDTO one = orderService.findOne("1534258807456994883");

        log.error("{}", one);
    }

    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(0, 1);
        Page list = orderService.findList(OPENID, pageRequest);

        log.error("{}", list.getContent());
    }

    @Test
    @Transactional
    public void cancel() {


        OrderDTO orderDTO = new OrderDTO();
        List<OrderMaster> orderMasterList = orderMasterService.findByOrderId("1534258807456994883");
        BeanUtils.copyProperties(orderMasterList.get(0), orderDTO);

        OrderDetail orderDetail = orderDetailService.findOne("1534258807681705790");

        List<OrderDetail> orderDetailList = Lists.newArrayList();
        orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);
        orderService.cancel(orderDTO);
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = new OrderDTO();
        List<OrderMaster> orderMasterList = orderMasterService.findByOrderId("1534258807456994883");
        BeanUtils.copyProperties(orderMasterList.get(0), orderDTO);

        OrderDetail orderDetail = orderDetailService.findOne("1534258807681705790");

        List<OrderDetail> orderDetailList = Lists.newArrayList();
        orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);
        orderService.finish(orderDTO);
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = new OrderDTO();
        List<OrderMaster> orderMasterList = orderMasterService.findByOrderId("1534258807456994883");
        BeanUtils.copyProperties(orderMasterList.get(0), orderDTO);

        OrderDetail orderDetail = orderDetailService.findOne("1534258807681705790");

        List<OrderDetail> orderDetailList = Lists.newArrayList();
        orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);
        orderService.paid(orderDTO);
    }

    @Test
    public void findList1() {
    }
}