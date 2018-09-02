package com.imooc.sell.service.impl;

import com.imooc.sell.service.BaseService;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-10
 * @Time: 10:28
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {


    protected abstract JpaRepository getDaoClass();

    @Override
    public void save(T t) {
        getDaoClass().save(t);
    }

    @Override
    public void delete(T t) {

        getDaoClass().delete(t);

    }

    @Override
    public void delete(Serializable id) {

        getDaoClass().delete(id);
    }

    @Override
    public void update(T t) {
        getDaoClass().save(t);

    }

    @Override
    public T findOne(Serializable id) {
        return (T) getDaoClass().findOne(id);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
//        pageable.getOffset()
        return getDaoClass().findAll(pageable);
    }

}
