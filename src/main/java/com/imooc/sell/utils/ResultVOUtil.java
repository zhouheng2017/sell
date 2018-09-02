package com.imooc.sell.utils;

import com.imooc.sell.vo.ResultVO;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-13
 * @Time: 16:55
 */
public class ResultVOUtil {

    public static ResultVO success(Object o) {
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg("成功");
        resultVO.setData(o);
        resultVO.setCode(0);

        return resultVO;
    }

    public static ResultVO success() {
        return success(null);

    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
