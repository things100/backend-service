package com.futao.springbootservice.service;

/**
 * @author futao
 * @date 2020/11/4
 */
public interface VerifyCodeService {
    /**
     * 发送验证码
     *
     * @param mobile 手机号
     * @return 验证码关联的key
     */
    String send(String mobile);
}
