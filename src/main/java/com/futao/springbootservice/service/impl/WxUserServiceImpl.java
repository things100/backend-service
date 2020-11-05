package com.futao.springbootservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.futao.springbootservice.entity.UserEntity;
import com.futao.springbootservice.entity.wx.WxUserEntity;
import com.futao.springbootservice.mapper.UserMapper;
import com.futao.springbootservice.mapper.WxUserMapper;
import com.futao.springbootservice.service.WxUserService;
import com.futao.starter.fustack.wx.miniprogram.model.WxBaseResult;
import com.futao.starter.fustack.wx.miniprogram.model.request.SubscribeMessage;
import com.futao.starter.fustack.wx.miniprogram.model.resuslt.AuthCode;
import com.futao.starter.fustack.wx.miniprogram.service.DynamicMessageService;
import com.futao.starter.fustack.wx.miniprogram.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;

/**
 * @author futao
 * @date 2020/11/2
 */
@Service
public class WxUserServiceImpl extends ServiceImpl<WxUserMapper, WxUserEntity> implements WxUserService {

    @Autowired
    private LoginService loginService;

    @Autowired
    private DynamicMessageService messageService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private WxUserMapper wxUserMapper;

    /**
     * 微信小程序登录
     *
     * @param code 临时票据，兑换用户token
     * @return 用户信息
     */
    @Override
    public UserEntity login(String code) {
        AuthCode authCode = loginService.getOpenIdByCode(code);
        WxUserEntity userEntity = this.getOne(Wrappers.<WxUserEntity>lambdaQuery().eq(WxUserEntity::getMiniOpenId, authCode.getOpenId()));
        if (userEntity == null) {
            throw new RuntimeException("请先注册");
        } else {
            return userMapper.selectById(userEntity.getUserId());
        }
    }

    @Override
    public WxBaseResult sendMessage() {
        SubscribeMessage message = new SubscribeMessage();
        UserEntity userEntity = userMapper.selectOne(
                Wrappers.<UserEntity>lambdaQuery().eq(UserEntity::getMobile, "18797811992"));
        WxUserEntity wxUserEntity = wxUserMapper.selectOne(Wrappers.<WxUserEntity>lambdaQuery().eq(WxUserEntity::getUserId, userEntity.getId()));

        message.setToUser(wxUserEntity.getMiniOpenId());
        message.setTemplateId("ZBCPEQztbXMyiwV79jUMh1dtqmIuk_Sddk5NjQVakqQ");

        message.setData(new JSONObject().fluentPut("thing1", new JSONObject().fluentPut("value", userEntity.getNickName()))
                .fluentPut("time2", new JSONObject().fluentPut("value", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(userEntity.getCreateDateTime())))
                .fluentPut("thing3", new JSONObject().fluentPut("value", userEntity.getMobile()))
        );
        message.setPage("pages/index/index");
        message.setMiniProgramState("developer");

        return messageService.sendSubscribeMessage(message);
    }
}
