package com.futao.springbootservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.futao.starter.fustack.db.IdTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

// TODO: 2020/12/2 做审核功能

/**
 * 分组与用户关联表
 *
 * @author futao
 * @date 2020/12/2
 */
@Getter
@Setter
@TableName("fustack_thing_group_user")
@Builder
public class ThingGroupUser extends IdTimeEntity {

    @Tolerate
    public ThingGroupUser() {
    }

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 事情组ID
     */
    private Long groupId;
    /**
     * @see com.futao.springbootservice.entity.enums.DeleteStatusEnum
     * 删除状态
     */
    private int deleteStatus;
    /**
     * 邀请用户主键
     */
    private Long inviteByUserId;
}
