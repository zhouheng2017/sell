package com.imooc.sell.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.imooc.sell.dto.CartDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-15
 * @Time: 16:05
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderForm {
    @NotEmpty(message = "姓名不可为空")
    private String name;
    @NotEmpty(message = "手机号不可以为空")
    private String phone;

    @NotEmpty
    private String address;
    @NotEmpty
    private String openid;
    @NotEmpty
    private String items;



}
