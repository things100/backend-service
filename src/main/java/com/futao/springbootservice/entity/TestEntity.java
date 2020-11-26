package com.futao.springbootservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.futao.starter.fustack.db.IdTimeEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author futao
 * @date 2020/11/19
 */
@Getter
@Setter
@TableName("fustack_test")
public class TestEntity extends IdTimeEntity {
    private String col1;
    private String col2;
    private String col3;
    private String col4;
    private String col5;
}
