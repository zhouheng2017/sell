package com.imooc.sell.controller;

import com.google.common.collect.Maps;
import com.imooc.sell.converter.OrderForm2OrderDTOConverter;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.form.OrderForm;
import com.imooc.sell.service.BuyerService;
import com.imooc.sell.service.OrderService;
import com.imooc.sell.utils.ResultVOUtil;
import com.imooc.sell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-15
 * @Time: 16:01
 */
@RestController
@RequestMapping("buyer/order")
@Slf4j
public class BuyerOrderController {



    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    @PostMapping("/create")
    public ResultVO create(@Valid OrderForm orderForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("[表单错误有移仓] {}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO converter = OrderForm2OrderDTOConverter.converter(orderForm);
        if (CollectionUtils.isEmpty(converter.getOrderDetailList())) {
            log.error("【创建订单】购物车不可以为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO orderDTO = orderService.create(converter);

        Map<String, String> map = Maps.newHashMap();
        map.put("orderId", orderDTO.getOrderId());

        String s = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx33fd4b0d103a6c74&redirect_uri=http://d6u9ks.natappfree.cc/weixin/auth&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";

        return ResultVOUtil.success(map);
    }

    @GetMapping("/list")
    public ResultVO orderList(@RequestParam("openid") String openid,
                              @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                              @RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {

        if (StringUtils.isEmpty(openid)) {
            log.error("查询订单列表openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest pageRequest = new PageRequest(page, size);

        Page list = orderService.findList(openid, pageRequest);

        return ResultVOUtil.success(list.getContent());
    }

    @GetMapping("/detail")
    public ResultVO detail(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {
        if (StringUtils.isEmpty(openid)) {
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO orderOne = buyerService.findOrderOne(openid, orderId);

        return ResultVOUtil.success(orderOne);
    }

    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {
        if (StringUtils.isEmpty(openid)) {
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        buyerService.cancelOrder(openid, orderId);

        return ResultVOUtil.success();
    }
}
