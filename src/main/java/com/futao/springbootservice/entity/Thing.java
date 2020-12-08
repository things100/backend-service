package com.futao.springbootservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.futao.starter.fustack.db.IdTimeEntity;
import lombok.*;

import java.time.LocalDate;

/**
 * 事情
 *
 * @author futao
 * @date 2020/12/2
 */

@TableName("fustack_thing")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
     * 顺序 小 -> 大
     */
    private int sortNum;
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
