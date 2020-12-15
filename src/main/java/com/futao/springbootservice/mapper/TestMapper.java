package com.futao.springbootservice.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.futao.springbootservice.entity.TestEntity;

/**
 * @author futao
 * @date 2020/11/19
 */
//@InterceptorIgnore(blockAttack = "true")
public interface TestMapper extends BaseMapper<TestEntity> {
}
