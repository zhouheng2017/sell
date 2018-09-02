package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-09
 * @Time: 20:38
 */
public interface ProductRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByCategoryType(Integer categoryType);

    List<ProductInfo> findByStatus(Integer status);

}
