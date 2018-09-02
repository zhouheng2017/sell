package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-10
 * @Time: 10:21
 */
@Service
public interface CategoryService extends BaseService<ProductCategory> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);


}
