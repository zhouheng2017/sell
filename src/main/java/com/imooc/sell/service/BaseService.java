package com.imooc.sell.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-10
 * @Time: 10:24
 */
public interface BaseService<T> {

    void save(T t);

    void delete(T t);

    void delete(Serializable id);

    void update(T t);

    T findOne(Serializable id);


    Page<T> findAll(Pageable pageable);

}
