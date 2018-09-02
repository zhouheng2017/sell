package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.SellerInfo;
import com.imooc.sell.repository.SellerRepository;
import com.imooc.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-14
 * @Time: 10:24
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    /**
     * 通过openid查询卖家端信息
     *
     * @param openid
     * @return
     */
    @Override
    public SellerInfo findSellerInfoByOpenId(String openid) {

        return sellerRepository.findByOpenid(openid);


    }
}
