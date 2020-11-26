package com.futao.springbootservice.configuration;

import com.futao.starter.fustack.auth.auth.UserAuth;
import com.futao.starter.fustack.auth.auth.impl.LoginUserAuth;
import com.futao.starter.fustack.auth.interceptors.UserAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author futao
 * @date 2020/11/5
 */
@Configuration
public class AppBeans {

    @Bean
    public UserAuthInterceptor userAuthInterceptor() {
        return new UserAuthInterceptor();
    }

    @Bean
    public LoginUserAuth loginUserAuth() {
        return new LoginUserAuth();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
