package com.futao.springbootservice.controller;

import com.futao.springbootservice.model.SingleValueWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

/**
 * @author futao
 * @date 2020/11/4
 */
class VerifyCodeControllerTest {

    @Test
    void send() {
        RestTemplate restTemplate = new RestTemplate();
        SingleValueWrapper<String> stringSingleValueWrapper = new SingleValueWrapper<>("18797811992");
        System.out.println(restTemplate.postForEntity("http://localhost:8080/verifyCode/send", stringSingleValueWrapper, String.class).getBody());
    }
}