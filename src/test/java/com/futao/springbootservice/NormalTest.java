package com.futao.springbootservice;

import com.alibaba.fastjson.JSON;
import com.sun.istack.internal.Interned;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author futao
 * @date 2020/10/30
 */
public class NormalTest {

    @Test
    public void test4(){
        ArrayList<Integer> integers = new ArrayList<>(4);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

        integers
                .forEach(x->{
                    if (x==2){
                        return;
                    }
                    System.out.println(x);
                });

    }

    @Test
    public void test3() {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256); //or HS384 or HS512
        System.out.println(key);
        System.out.println(key.getFormat());
        System.out.println(JSON.toJSONString(key));
    }

    @Test
    public void test1() {
        String s = "123123123123&&1231323&";
        System.out.println(s.substring(0, s.lastIndexOf("&")));
    }

    @Test
    public void test2() {
        System.out.println(JSON.parseArray("", String.class));
        System.out.println(JSON.parseArray(null, String.class));
    }
}
