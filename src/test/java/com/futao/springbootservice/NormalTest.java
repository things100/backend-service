package com.futao.springbootservice;

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
}
