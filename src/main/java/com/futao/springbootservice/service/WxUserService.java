package com.futao.springbootservice.service;

import com.futao.springbootservice.entity.UserEntity;
import com.futao.starter.fustack.wx.miniprogram.model.WxBaseResult;

/**
 * @author futao
 * @date 2020/11/2
 */
public interface WxUserService {
    /**
     * 微信小程序登录
     *
     * @param code 临时票据，兑换用户token
     * @return 用户信息
     */
    UserEntity login(String code);

    WxBaseResult sendMessage();
}
