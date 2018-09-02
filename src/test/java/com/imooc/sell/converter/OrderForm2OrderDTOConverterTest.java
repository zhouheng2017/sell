package com.imooc.sell.converter;

import com.imooc.sell.SellApplicationTests;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.form.OrderForm;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-15
 * @Time: 16:44
 */
public class OrderForm2OrderDTOConverterTest extends SellApplicationTests {


    @Test
    public void converter() {
        OrderForm orderForm = OrderForm.builder()
                .address("address")
                .phone("1234434433")
                .name("name")
                .openid("openid")
                .items("[{\n" +
                        "  \"productId\": \"1423113435324\",\n" +
                        "  \"productQuantity\": \"2\"\n" +
                        "}]").build();
        OrderDTO converter = OrderForm2OrderDTOConverter.converter(orderForm);

        System.out.println(converter);

    }
}