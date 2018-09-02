package com.imooc.sell.repository;

import com.imooc.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-09
 * @Time: 20:39
 */
public interface SellerRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);


}
