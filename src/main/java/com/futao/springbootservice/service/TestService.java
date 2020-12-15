package com.futao.springbootservice.service;

import com.futao.springbootservice.entity.TestEntity;

import java.util.List;

/**
 * @author futao
 * @date 2020/11/19
 */
public interface TestService {
    List<TestEntity> distinct();

    void dangerDbOps(int ops);
}
