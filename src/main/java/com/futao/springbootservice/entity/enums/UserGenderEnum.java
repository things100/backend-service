package com.futao.springbootservice.entity.enums;

import com.futao.starter.fusstack.foundation.model.IEnum;
import lombok.AllArgsConstructor;

/**
 * 用户性别
 *
 * @author futao
 * @date 2020/11/2
 */
@AllArgsConstructor
public enum UserGenderEnum implements IEnum<Integer> {

    /**
     * 0=未知
     */
    UN_KNOW(0, "未知"),

    /**
     * 1=男
     */
    MALE(1, "男"),

    /**
     * 2=女
     */
    FEMALE(2, "女");

    private int gender;
    private String desc;

    @Override
    public Integer getValue() {
        return gender;
    }

    @Override
    public String getDescription() {
        return desc;
    }
}
