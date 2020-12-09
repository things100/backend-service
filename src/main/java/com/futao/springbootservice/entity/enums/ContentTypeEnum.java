package com.futao.springbootservice.entity.enums;

import com.futao.starter.fusstack.foundation.model.IEnum;
import lombok.AllArgsConstructor;

/**
 * @author futao
 * @date 2020/12/9
 */
@AllArgsConstructor
public enum ContentTypeEnum implements IEnum<Integer> {
    /**
     * 1=文本
     */
    TEXT(1, "文本"),
    /**
     * 2=图片
     */
    IMAGE(2, "图片"),
    /**
     * 3=视频
     */
    VIDEO(3, "视频");
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
