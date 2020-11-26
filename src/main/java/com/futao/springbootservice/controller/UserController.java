package com.futao.springbootservice.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.futao.springbootservice.entity.UserEntity;
import com.futao.springbootservice.model.UserLogin;
import com.futao.springbootservice.model.UserRegister;
import com.futao.springbootservice.model.result.UserResult;
import com.futao.springbootservice.service.UserService;
import com.futao.starter.fustack.auth.annotations.SkipUserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 用户操作
 *
 * @author futao
 * @date 2020/11/2
 */
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @SkipUserAuth
    @PostMapping("/login")
    public UserResult login(@RequestBody @Validated UserLogin userLogin) {
        return userService.login(userLogin);
    }

    @SkipUserAuth
    @PostMapping("/register")
    public UserEntity register(@RequestBody UserRegister userRegister) {
        return userService.register(userRegister);
    }

    @GetMapping("/list")
    public Page<UserEntity> users(
            @RequestParam(value = "pageNum", required = false)
                    int pageNum,
            @RequestParam(value = "pageSize", required = false)
                    int pageSize,

            @NotBlank
            @RequestParam(value = "mobile", required = false)
                    String mobile
    ) {
        return userService.list(pageNum, pageSize, mobile);
    }
}
