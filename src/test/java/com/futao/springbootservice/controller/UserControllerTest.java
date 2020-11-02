package com.futao.springbootservice.controller;

import com.alibaba.fastjson.JSON;
import com.futao.springbootservice.entity.UserEntity;
import com.futao.springbootservice.model.UserLogin;
import com.futao.springbootservice.model.UserRegister;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author futao
 * @date 2020/11/2
 */
@Slf4j
class UserControllerTest {


    @Test
    void login() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                RestTemplate restTemplate = new RestTemplate();
                UserLogin userLogin = new UserLogin();
                userLogin.setMobile("18797811992");
                userLogin.setPassword("123456");
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ResponseEntity<UserEntity> userEntityResponseEntity = restTemplate.postForEntity("http://localhost:8080/user/login", userLogin, UserEntity.class);
                log.info("{}", JSON.toJSONString(userEntityResponseEntity.getBody()));
            });
        }

        countDownLatch.countDown();

        TimeUnit.SECONDS.sleep(5L);

        executorService.shutdown();
    }

    @Test
    void register() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                RestTemplate restTemplate = new RestTemplate();
                UserRegister userRegister = new UserRegister();
                userRegister.setMobile("18797811992");
                userRegister.setPassword("123456");
                userRegister.setNickName("flyElephant");

                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ResponseEntity<UserEntity> userEntityResponseEntity = restTemplate.postForEntity("http://localhost:8080/user/register", userRegister, UserEntity.class);
                log.info("{}", JSON.toJSONString(userEntityResponseEntity.getBody()));
            });
        }

        countDownLatch.countDown();

        TimeUnit.SECONDS.sleep(5L);

        executorService.shutdown();
    }
}