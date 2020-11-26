package com.futao.springbootservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.futao.springbootservice.entity.UserEntity;
import com.futao.springbootservice.model.UserLogin;
import com.futao.springbootservice.model.UserRegister;
import com.futao.springbootservice.model.result.UserResult;

/**
 * @author futao
 * @date 2020/11/2
 */
public interface UserService {

    /**
     * 用户号登录
     *
     * @param userLogin 登录信息
     * @return 用户信息
     */
    UserResult login(UserLogin userLogin);

    /**
     * 用户注册
     *
     * @param userRegister 注册信息
     * @return 用户信息
     */
    UserEntity register(UserRegister userRegister);

    /**
     * 查询用户列表
     *
     * @return
     * @param pageNum
     * @param pageSize
     * @param mobile
     */
    Page<UserEntity> list(int pageNum, int pageSize, String mobile);
}
