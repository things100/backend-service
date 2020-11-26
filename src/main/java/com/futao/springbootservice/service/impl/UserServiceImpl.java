package com.futao.springbootservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.futao.springbootservice.entity.UserEntity;
import com.futao.springbootservice.mapper.UserMapper;
import com.futao.springbootservice.model.UserLogin;
import com.futao.springbootservice.model.UserRegister;
import com.futao.springbootservice.model.result.UserResult;
import com.futao.springbootservice.service.UserService;
import com.futao.starter.fustack.auth.jwt.JwtUtil;
import com.futao.starter.fustack.db.IdTimeEntity;
import com.futao.starter.fustack.exceptions.LogicException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 用户号登录
     *
     * @param userLogin 登录信息
     * @return 用户信息
     */
    @Override
    public UserResult login(UserLogin userLogin) {
        UserEntity userEntity = this.getOne(Wrappers.<UserEntity>lambdaQuery()
                .eq(UserEntity::getMobile, userLogin.getMobile())
                .eq(UserEntity::getPassword, userLogin.getPassword())
        );
        if (userEntity == null) {
            throw new LogicException("用户名或者密码不正确，请重试");
        }
        String jwt = jwtUtil.encode(userEntity.getId());
        log.debug("gen jwt:{}", jwt);
        UserResult userResult = new UserResult();
        BeanUtils.copyProperties(userEntity, userResult, "password");
        userResult.setToken(jwt);

        System.out.println(JSON.toJSONString(jwtUtil.decode(jwt)));
        return userResult;
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
            throw new LogicException("当前手机号已注册，请直接登录");
        }
        UserEntity newUserEntity = UserEntity.builder()
                .mobile(userRegister.getMobile())
                .password(userRegister.getPassword())
                .nickName(userRegister.getNickName())
                .build();
        this.save(newUserEntity);
        return newUserEntity;
    }


    @Override
    public Page<UserEntity> list(int pageNum, int pageSize, String mobile) {
        return this.page(new Page<>(pageNum, pageSize),
                Wrappers.<UserEntity>lambdaQuery()
                        .like(StringUtils.isNotBlank(mobile), UserEntity::getMobile, mobile)
                        .orderByDesc(IdTimeEntity::getCreateDateTime)
        );
    }

}
