package com.imooc.sell.converter;

import org.dozer.CustomConverter;
import org.dozer.MappingException;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Method;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-15
 * @Time: 13:47
 */
public class EnumIntegerBiDirectionalDozerConverter implements CustomConverter {

    @Override
    public Object convert(Object destination, Object source, Class<?> destinationClass, Class<?> sourceClass) {
        if (ObjectUtils.isEmpty(source)) {
            return null;
        }
        if (source instanceof Enum) {
            return getInteger(destinationClass, source);
        } else if (source instanceof Integer) {
            return getEnum(destinationClass, source);
        } else {
            throw new MappingException(new StringBuilder("Converter ").append(this.getClass().getSimpleName())
                    .append(" was used incorrectly. Arguments were: ").append(destinationClass.getClass().getName())
                    .append(" and ").append(source).toString());
        }
    }

    private Object getInteger(Class<?> destinationClass, Object source) {
        try {
            Enum<?> em = (Enum<?>) source;
            Class<?> clazz = em.getDeclaringClass();
            Method getCode = clazz.getMethod("getCode");
            Object code = getCode.invoke(source);
            return Integer.valueOf((String) code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Object getEnum(Class<?> destinationClass, Object source) {
        try {
            Method m = destinationClass.getDeclaredMethod("valueOfCode", String.class);
            Object enumeration = m.invoke(destinationClass.getClass(), String.valueOf(source));
            return enumeration;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
