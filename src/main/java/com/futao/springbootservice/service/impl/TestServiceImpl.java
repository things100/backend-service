package com.futao.springbootservice.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.futao.springbootservice.entity.TestEntity;
import com.futao.springbootservice.mapper.TestMapper;
import com.futao.springbootservice.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author futao
 * @date 2020/11/19
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public List<TestEntity> distinct() {
        return testMapper.selectList(Wrappers.<TestEntity>query().select("DISTINCT col1,col2,col3"));
    }
}
