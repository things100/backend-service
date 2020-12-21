package com.futao.springbootservice;

import com.futao.springbootservice.configuration.AppProperties;
import org.jasypt.encryption.StringEncryptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author futao
 * @date 2020/10/29
 */
@MapperScan("com.futao.springbootservice.mapper")
@SpringBootApplication
@EnableConfigurationProperties({AppProperties.class})
public class SpringbootServiceApplication implements CommandLineRunner {

    @Autowired
    private StringEncryptor encryptor;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(encryptor.encrypt("1"));
    }
}
