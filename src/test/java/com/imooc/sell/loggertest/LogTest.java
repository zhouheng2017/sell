package com.imooc.sell.loggertest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-09
 * @Time: 15:36
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {
    @Test
    public void test() {

        log.info("hello");
        log.error("error");
        log.debug("debug");

    }
}
