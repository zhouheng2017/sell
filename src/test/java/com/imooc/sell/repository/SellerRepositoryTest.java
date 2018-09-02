package com.imooc.sell.repository;

import com.imooc.sell.dataobject.SellerInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-01
 * @Time: 21:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerRepositoryTest {

    @Autowired
    private SellerRepository sellerRepository;


    @Test
    public void findByOpenid() {
        SellerInfo openid = sellerRepository.findByOpenid("openid");
        System.out.println(openid);

    }

    @Test
    public  void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setId("openId");
        sellerInfo.setOpenid("openId");
        sellerInfo.setUsername("username");
        sellerInfo.setPassword("password");
        sellerRepository.save(sellerInfo);

    }
}