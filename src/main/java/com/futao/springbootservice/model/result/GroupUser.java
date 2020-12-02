package com.futao.springbootservice.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author futao
 * @date 2020/12/2
 */
@Getter
@Setter
public class GroupUser {
    /**
     * 用户主键
     */
    private Long id;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String avatar;
    /**
     * @see com.futao.springbootservice.entity.enums.UserGenderEnum
     * 性别
     */
    private Integer gender;
    /**
     * 加入组别的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime joinGroupDateTime;
}
