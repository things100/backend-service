package com.futao.springbootservice.entity;

import com.futao.starter.fustack.db.IdTimeEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 事情记录
 *
 * @author futao
 * @date 2020/12/2
 */
@Getter
@Setter
public class ThingRecord extends IdTimeEntity {
    /**
     * 关联的事情ID
     */
    private Long thingId;

    /**
     * 资源类型
     */
    private int resourceType;

    /**
     * 资源内容
     */
    private String resourceContent;

    /**
     * 前一个记录的ID
     */
    private Long preRecordId;

    /**
     * 删除状态
     *
     * @see com.futao.springbootservice.entity.enums.DeleteStatusEnum
     */
    private int deleteStatus;
    /**
     * 记录发生的关联地址
     */
    private Long addressId;

    private Address address;
}
