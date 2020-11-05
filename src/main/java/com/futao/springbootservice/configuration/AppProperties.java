package com.futao.springbootservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author futao
 * @date 2020/11/4
 */
@ConfigurationProperties(prefix = "springboot-service")
public class AppProperties {

    /**
     * 验证码有效分钟
     */
    private int verifyCodeExpireMinute;

    public int getVerifyCodeExpireMinute() {
        return verifyCodeExpireMinute;
    }

    public void setVerifyCodeExpireMinute(int verifyCodeExpireMinute) {
        this.verifyCodeExpireMinute = verifyCodeExpireMinute;
    }
}
