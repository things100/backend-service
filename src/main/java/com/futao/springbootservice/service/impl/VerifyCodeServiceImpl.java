package com.futao.springbootservice.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.futao.springbootservice.configuration.AppProperties;
import com.futao.springbootservice.model.app.Constants;
import com.futao.springbootservice.model.enums.MessageTemplateEnum;
import com.futao.springbootservice.service.VerifyCodeService;
import com.futao.springbootservice.utils.AppUtil;
import com.futao.starter.fustack.tencent.cloud.shortmessage.service.ShortMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author futao
 * @date 2020/11/4
 */
@Slf4j
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {

    @Autowired
    private ShortMessageService shortMessageService;

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 发送验证码
     *
     * @param mobile 手机号
     * @return 验证码关联的key
     */
    @Override
    public String send(String mobile) {
        String code = RandomUtil.randomNumbers(4);
        shortMessageService.send(MessageTemplateEnum.REGISTER, new String[]{code, String.valueOf(appProperties.getVerifyCodeExpireMinute())}, mobile);
        String uuid = AppUtil.uuid();
        redisTemplate.opsForValue().set(Constants.RedisKey.VERIFY_CODE_KEY + uuid, code, appProperties.getVerifyCodeExpireMinute(), TimeUnit.MINUTES);
        return uuid;
    }
}
