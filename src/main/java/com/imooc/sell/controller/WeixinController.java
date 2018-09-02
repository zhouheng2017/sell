package com.imooc.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-09-01
 * @Time: 9:44
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
    public static final String APPID = "wx33fd4b0d103a6c74";
    public static final String SECRET = "371f34a62309fbff653d194c5cb949f4";

    @GetMapping("/auth")
    public String auth(@RequestParam("code") String code) {

        log.info("进入微信");
        log.info("{}", code);
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid=" + APPID +
                "&secret=" + SECRET +
                "&code=" + code +
                "&grant_type=authorization_code";

        String response = restTemplate.getForObject(url, String.class);

        log.info("Response{}", response);

        return response;
    }

}
