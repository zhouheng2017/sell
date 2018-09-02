package com.imooc.sell.repository;

import lombok.NonNull;
import lombok.Synchronized;
import lombok.val;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-09
 * @Time: 21:29
 */
public class Test {

    public static void main(String[] args) {
        Integer a = null;
        Integer b = null;
        int add = add(a, b);
        val aa = 2;
        System.out.println(add);


    }
    @Synchronized
    public static int add(@NonNull int a, @NonNull int b) {
        return a+b;
    }
}
