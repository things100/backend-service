package com.futao.springbootservice.model.result;

import com.futao.springbootservice.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author futao
 * @date 2020/11/11
 */
@Getter
@Setter
public class UserResult extends UserEntity {
    private String token;
}
