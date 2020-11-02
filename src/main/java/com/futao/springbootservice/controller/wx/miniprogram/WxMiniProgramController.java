package com.futao.springbootservice.controller.wx.miniprogram;

import com.futao.starter.fustack.wx.miniprogram.model.resuslt.AuthCode;
import com.futao.starter.fustack.wx.miniprogram.service.AccessTokenService;
import com.futao.starter.fustack.wx.miniprogram.service.LoginService;
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
    private LoginService loginService;

    @Autowired
    private AccessTokenService accessTokenService;

    @GetMapping("/login")
    public AuthCode login(@RequestParam("code") String code) {
        return loginService.getOpenIdByCode(code);
    }

    @GetMapping("/acc")
    public String acc() {
        return accessTokenService.get();
    }

    @GetMapping("/userInfo/{openId}")
    public void userInfoByOpenId(@PathVariable String openId) {

    }
}
