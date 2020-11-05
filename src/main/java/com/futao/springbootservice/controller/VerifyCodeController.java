package com.futao.springbootservice.controller;

import com.futao.springbootservice.model.SingleValueWrapper;
import com.futao.springbootservice.service.VerifyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author futao
 * @date 2020/11/4
 */

@RestController
@RequestMapping("/verifyCode")
public class VerifyCodeController {

    @Autowired
    private VerifyCodeService verifyCodeService;

    /**
     * 发送验证码
     *
     * @param mobile
     * @return
     */
    @PostMapping("/send")
    public String send(@RequestBody SingleValueWrapper<String> mobile) {
        return verifyCodeService.send(mobile.getValue());
    }
}
