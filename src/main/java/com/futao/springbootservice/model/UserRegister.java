package com.futao.springbootservice.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author futao
 * @date 2020/11/2
 */
@Getter
@Setter
public class UserRegister {
    private String mobile;
    private String password;
    private String nickName;
}
