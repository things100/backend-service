package com.futao.springbootservice.entity.wx;

import com.baomidou.mybatisplus.annotation.TableName;
import com.futao.starter.fustack.db.IdTimeEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 微信-用户关联表
 *
 * @author futao
 * @date 2020/11/2
 */
@TableName("fustack_wx_user")
@Getter
@Setter
public class WxUserEntity extends IdTimeEntity {

    /**
     * 用户主键
     */
    private long userId;

    /**
     * 微信小程序openId
     */
    private String miniOpenId;
}
