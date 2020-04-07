package com.tech.uc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tech.uc.mapper")
public class UCApplication {

    public static void main(String[] args) {
        SpringApplication.run(UCApplication.class, args);
    }

}
