package com.futao.springbootservice.controller.wx.miniprogram;

import com.futao.springbootservice.entity.UserEntity;
import com.futao.springbootservice.model.SingleValueWrapper;
import com.futao.springbootservice.service.WxUserService;
import com.futao.starter.fustack.wx.miniprogram.model.WxBaseResult;
import com.futao.starter.fustack.wx.miniprogram.service.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author futao
 * @date 2020/10/29
 */
@RestController
@RequestMapping("/wx/miniprogram")
public class WxMiniProgramController {

    @Autowired
    private WxUserService wxUserService;

    @Autowired
    private AccessTokenService accessTokenService;

    @PostMapping("/login")
    public UserEntity login(@RequestBody SingleValueWrapper<String> code) {
        return wxUserService.login(code.getValue());
    }

    @GetMapping("/bind")
    public String acc() {
        return accessTokenService.get();
    }

    @PostMapping("/sendMessage")
    public WxBaseResult sendMessage() {
        return wxUserService.sendMessage();
    }
}
