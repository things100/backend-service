package com.futao.springbootservice.controller.douban;

import com.alibaba.fastjson.JSONObject;
import com.futao.springbootservice.service.DouBanService;
import com.futao.starter.fustack.auth.annotations.SkipUserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author futao
 * @date 2020/11/26
 */
@SkipUserAuth
@RestController
@RequestMapping("/douban")
public class DouBanController {

    @Autowired
    private DouBanService douBanService;

    @GetMapping("/movies")
    public JSONObject movies() {
        return douBanService.movieList();
    }
}
