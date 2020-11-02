package com.futao.springbootservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.futao.springbootservice.entity.UserEntity;
import com.futao.springbootservice.mapper.UserMapper;
import com.futao.springbootservice.model.UserLogin;
import com.futao.springbootservice.model.UserRegister;
import com.futao.springbootservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author futao
 * @date 2020/11/2
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    /**
     * 用户号登录
     *
     * @param userLogin 登录信息
     * @return 用户信息
     */
    @Override
    public UserEntity login(UserLogin userLogin) {
        UserEntity userEntity = this.getOne(Wrappers.<UserEntity>lambdaQuery()
                .eq(UserEntity::getMobile, userLogin.getMobile())
                .eq(UserEntity::getPassword, userLogin.getPassword())
        );
        if (userEntity == null) {
            throw new RuntimeException("用户名或者密码不正确，请重试");
        }
        return userEntity;
    }

    /**
     * 用户注册
     *
     * @param userRegister 注册信息
     * @return 用户信息
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    @Override
    public UserEntity register(UserRegister userRegister) {
        log.info("{}", JSON.toJSONString(userRegister));
        UserEntity userEntity = this.getOne(Wrappers.<UserEntity>lambdaQuery()
                .eq(UserEntity::getMobile, userRegister.getMobile())
        );
        if (userEntity != null) {
            throw new RuntimeException("当前手机号已注册，请直接登录");
        }
        UserEntity newUserEntity = UserEntity.builder()
                .mobile(userRegister.getMobile())
                .password(userRegister.getPassword())
                .nickName(userRegister.getNickName())
                .build();
        this.save(newUserEntity);
        return newUserEntity;
    }
}
