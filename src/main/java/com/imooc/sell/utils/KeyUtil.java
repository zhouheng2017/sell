package com.imooc.sell.utils;

import lombok.Synchronized;

import java.util.Random;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-14
 * @Time: 14:59
 */
public class KeyUtil {

    @Synchronized
    public static String getUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        System.out.println(random.nextInt(900000));

        return System.currentTimeMillis() + String.valueOf(number);
    }

    public static void main(String[] args) {
        String uniqueKey = KeyUtil.getUniqueKey();
        System.out.println(uniqueKey);

    }
}
