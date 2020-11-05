package com.futao.springbootservice;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

/**
 * @author futao
 * @date 2020/10/30
 */
public class NormalTest {

    @Test
    public void test1(){
        String s = "123123123123&&1231323&";
        System.out.println(s.substring(0, s.lastIndexOf("&")));
    }

    @Test
    public void test2(){
        System.out.println(JSON.parseArray("", String.class));
        System.out.println(JSON.parseArray(null, String.class));
    }
}
