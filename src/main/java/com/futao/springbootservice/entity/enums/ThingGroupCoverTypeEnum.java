package com.futao.springbootservice.entity.enums;

import com.futao.starter.fusstack.foundation.model.IEnum;
import lombok.AllArgsConstructor;

/**
 * @author futao
 * @date 2020/12/4
 */
@AllArgsConstructor
public enum ThingGroupCoverTypeEnum implements IEnum<Integer> {
    /**
     * 1=图片
     */
    IMAGE(1, "图片"),
    /**
     * 2=视频
     */
    VIDEO(2, "视频");

    private final int type;
    private final String description;

    @Override
    public Integer getValue() {
        return type;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
