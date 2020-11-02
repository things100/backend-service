package com.futao.springbootservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.futao.starter.fustack.db.IdTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.time.LocalDate;

/**
 * 用户表
 *
 * @author futao
 * @date 2020/11/2
 */
@TableName("fustack_user")
@Getter
@Setter
@Builder
public class UserEntity extends IdTimeEntity {

    @Tolerate
    public UserEntity() {
    }

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * @see com.futao.springbootservice.entity.enums.UserGenderEnum
     * 性别
     */
    private Integer gender;

}
