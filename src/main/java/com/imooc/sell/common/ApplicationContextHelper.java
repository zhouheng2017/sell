package com.imooc.sell.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-15
 * @Time: 16:27
 */
@Component("applicationContextHelper")
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {

        applicationContext = context;
    }

    public static <T> T popBean(Class<T> tClass) {

        if (ObjectUtils.isEmpty(applicationContext)) {
            return null;

        }
        return applicationContext.getBean(tClass);

    }

    public static <T> T popBean(String name, Class<T> tClass) {

        if (ObjectUtils.isEmpty(applicationContext)) {
            return null;

        }
        return applicationContext.getBean(name, tClass);

    }
}
