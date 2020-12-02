package com.futao.springbootservice.entity.enums;

import com.futao.starter.fusstack.foundation.model.IEnum;
import lombok.AllArgsConstructor;

/**
 * 删除状态
 *
 * @author futao
 * @date 2020/12/2
 */
@AllArgsConstructor
public enum DeleteStatusEnum implements IEnum<Integer> {

    /**
     * 0=已删除
     */
    DELETED(0, "已删除"),

    /**
     * 1=正常
     */
    NORMAL(1, "正常");

    private final int status;
    private final String description;

    @Override
    public Integer getValue() {
        return status;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
