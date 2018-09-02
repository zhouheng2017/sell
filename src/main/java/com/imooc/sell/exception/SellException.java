package com.imooc.sell.exception;

import com.imooc.sell.enums.ResultEnum;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-14
 * @Time: 10:47
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {

        super(resultEnum.getMessage());
        this.code = code;
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
