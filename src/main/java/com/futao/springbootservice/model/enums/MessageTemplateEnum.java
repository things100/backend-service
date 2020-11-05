package com.futao.springbootservice.model.enums;

import com.futao.starter.fustack.tencent.cloud.shortmessage.model.IMessageTemplateEnum;
import lombok.AllArgsConstructor;

/**
 * @author futao
 * @date 2020/11/4
 */
@AllArgsConstructor
public enum MessageTemplateEnum implements IMessageTemplateEnum {
    REGISTER("307972", "注册");

    private final String templateId;
    private final String description;

    @Override
    public String getTemplateId() {
        return templateId;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
