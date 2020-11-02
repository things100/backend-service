package com.futao.springbootservice.controller.wx.miniprogram;

import com.alibaba.fastjson.JSON;
import com.futao.springbootservice.entity.UserEntity;
import com.futao.springbootservice.model.SingleValueWrapper;
import com.futao.starter.fustack.wx.miniprogram.model.WxBaseResult;
import com.sun.xml.internal.fastinfoset.util.ValueArray;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author futao
 * @date 2020/11/2
 */
@Slf4j
class WxMiniProgramControllerTest {

    @Test
    void login() {
        RestTemplate restTemplate = new RestTemplate();
        SingleValueWrapper<String> singleValueWrapper = new SingleValueWrapper<>("091gMb000WkqzK1ncC000uBfIa1gMb0b");

        ResponseEntity<UserEntity> userEntityResponseEntity = restTemplate.postForEntity("http://localhost:8080/wx/miniprogram/login", singleValueWrapper, UserEntity.class);
        UserEntity body = userEntityResponseEntity.getBody();
        log.info("{}", JSON.toJSONString(body));
    }

    @Test
    void acc() {
    }

    @Test
    void userInfoByOpenId() {
    }

    @Test
    void sendMessage() {
        RestTemplate restTemplate = new RestTemplate();
        WxBaseResult body = restTemplate.postForEntity("http://localhost:8080/wx/miniprogram/sendMessage", null, WxBaseResult.class).getBody();
        System.out.println(JSON.toJSONString(body));
    }
}