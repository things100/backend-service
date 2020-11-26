package com.futao.springbootservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author futao
 * @date 2020/11/2
 */
@Getter
@Setter
public class UserLogin {
    private String mobile;
    @NotBlank
    private String password;
}
