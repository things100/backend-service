package com.futao.springbootservice.controller;

import com.futao.springbootservice.entity.TestEntity;
import com.futao.springbootservice.service.TestService;
import com.futao.starter.fustack.auth.annotations.SkipUserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author futao
 * @date 2020/11/19
 */
@SkipUserAuth
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/distinct")
    public List<TestEntity> distinct() {
        return testService.distinct();
    }


    @PutMapping("/dangerDbOps/{ops}")
    public void dangerDbOps(@PathVariable("ops") Integer ops) {
        testService.dangerDbOps(ops);
    }
}
