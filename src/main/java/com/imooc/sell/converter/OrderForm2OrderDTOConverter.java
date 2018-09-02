package com.imooc.sell.converter;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.imooc.sell.common.ApplicationContextHelper;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.form.OrderForm;
import com.imooc.sell.utils.IGenerator;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-15
 * @Time: 16:27
 */
public class OrderForm2OrderDTOConverter {


    public static OrderDTO converter(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        IGenerator iGenerator = ApplicationContextHelper.popBean(IGenerator.class);
        iGenerator.convert(orderForm, orderDTO);

        List<OrderDetail> orderDetail = Lists.newArrayList();
        try {
            orderDetail = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

        orderDTO.setOrderDetailList(orderDetail);

        return orderDTO;
    }
}
