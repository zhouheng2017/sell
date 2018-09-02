package com.imooc.sell.vo;

import lombok.Data;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-10
 * @Time: 15:12
 */
@Data
public class ResultVO<T> {
    /** code */
    private Integer code;

    private String msg;

    private T data;

    public static ResultVO successCode() {
        ResultVO resultVO = new ResultVO(0);
        return resultVO;
    }

    public static <T> ResultVO successData(T data) {

        ResultVO resultVO = new ResultVO(0);
        resultVO.setData(data);

        return resultVO;
    }

    public static <T> ResultVO successMsgData(String msg, T data) {

        ResultVO resultVO = new ResultVO(0);
        resultVO.setMsg(msg);

        resultVO.setData(data);

        return resultVO;
    }

    public static <T> ResultVO fail(String msg) {

        ResultVO resultVO = new ResultVO(1);
        resultVO.setMsg(msg);
        return resultVO;
    }


    public ResultVO() {
    }

    public ResultVO(Integer code) {
        this.code = code;
    }
}
