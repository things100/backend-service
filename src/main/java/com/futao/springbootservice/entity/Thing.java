package com.futao.springbootservice.entity;

import com.futao.starter.fustack.db.IdTimeEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * 事情
 *
 * @author futao
 * @date 2020/12/2
 */
@Getter
@Setter
public class Thing extends IdTimeEntity {
    /**
     * 事情所属分组ID
     */
    private long thingGroupId;
    /**
     * 事情标题
     */
    private String title;

    /**
     * 前一个事情的id
     */
    private int preThingId;
    /**
     * @see com.futao.springbootservice.entity.enums.DeleteStatusEnum
     * 删除状态
     */
    private int deleteStatus;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 完成时间
     */
    private LocalDate completeDate;
    /**
     * 是否完成
     */
    private boolean complete;
}
