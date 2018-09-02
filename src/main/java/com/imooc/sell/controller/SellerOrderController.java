package com.imooc.sell.controller;

import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.service.OrderService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-01
 * @Time: 15:45
 */
@Slf4j
@RestController
@RequestMapping("/seller/order")
public class SellerOrderController {

    @Autowired
    private OrderService orderService;


    /**
     * 订单列表
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                             @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                             Map<String, Object> map) {

        Pageable pageRequest = new PageRequest(page - 1, size);

        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);
        List<OrderDTO> content = orderDTOPage.getContent();

        log.error("OrderDto 【content】{}", orderDTOPage.getContent());
        map.put("orderDTOPage", orderDTOPage);
        map.put("content", content);
        ModelAndView modelAndView = new ModelAndView("/order/list", map);

        return modelAndView;
    }

    /**
     * 取消商品
     *
     * @param orderId
     * @param map
     * @return
     */
    @RequestMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId, Map<String, Object> map) {

        OrderDTO orderDTO = null;
        try {
            orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);

        } catch (SellException e) {
            e.printStackTrace();
            log.error("【卖家订单取消订单不存在】");
            map.put("msg", ResultEnum.ORDER_NOT_EXIST.getMessage());

            map.put("url", "/seller/order/list");
            return new ModelAndView("common/error", map);
        }


        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());

        map.put("url", "/seller/order/list");
        return new ModelAndView("common/success");

    }

    /**
     * 商品详情
     *
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId, Map<String, Object> map) {
        OrderDTO orderDTO = null;
        try {
            orderDTO = orderService.findOne(orderId);
        } catch (SellException e) {
            e.printStackTrace();
            log.error("【卖家订单详情】");
            map.put("msg", ResultEnum.ORDER_NOT_EXIST.getMessage());

            map.put("url", "/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("orderDTO", orderDTO);
        return new ModelAndView("order/detail");
    }

    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId, Map<String, Object> map) {
        OrderDTO orderDTO = null;
        try {
            orderDTO = orderService.findOne(orderId);
        } catch (SellException e) {
            log.error("【卖家订单完成】");
            map.put("msg", ResultEnum.ORDER_NOT_EXIST.getMessage());

            map.put("url", "/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());

        map.put("url", "/seller/order/list");

        return new ModelAndView("common/success", map);
    }

}
