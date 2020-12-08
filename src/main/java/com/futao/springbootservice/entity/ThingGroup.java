package com.futao.springbootservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.futao.starter.fustack.db.IdTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.time.LocalDate;

/**
 * 事情分组
 *
 * @author futao
 * @date 2020/12/2
 */
@TableName("fustack_thing_group")
@Getter
@Setter
@Builder
public class ThingGroup extends IdTimeEntity {

    @Tolerate
    public ThingGroup() {
    }

    /**
     * 分组标题
     */
    private String title;
    /**
     * @see com.futao.springbootservice.entity.enums.DeleteStatusEnum
     * 删除状态
     */
    private int deleteStatus;
    /**
     * 是否完成
     */
    private boolean complete;
    /**
     * 完成日期
     */
    private LocalDate completeDate;
    /**
     * 封面
     */
    private String cover;

    /**
     * 封面类型
     *
     * @see com.futao.springbootservice.entity.enums.ThingGroupCoverTypeEnum
     */
    private int coverType;
    /**
     * 描述
     */
    private String description;
    /**
     * 是否是公开的
     */
    private boolean open;
}
