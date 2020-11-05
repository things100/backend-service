package com.futao.springbootservice.utils;

import java.util.UUID;

/**
 * APP工具类
 *
 * @author futao
 * @date 2020/11/4
 */
public class AppUtil {

    /**
     * 获取不带`-`的UUID
     *
     * @return 不带`-`的UUID
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
