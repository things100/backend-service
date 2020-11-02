package com.futao.springbootservice.controller;

import com.futao.springbootservice.entity.UserEntity;
import com.futao.springbootservice.model.UserLogin;
import com.futao.springbootservice.model.UserRegister;
import com.futao.springbootservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户操作
 *
 * @author futao
 * @date 2020/11/2
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public UserEntity login(@RequestBody UserLogin userLogin) {
        return userService.login(userLogin);
    }

    @PostMapping("/register")
    public UserEntity register(@RequestBody UserRegister userRegister) {
        return userService.register(userRegister);
    }
}
