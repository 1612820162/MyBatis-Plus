package com.example.mplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mplus.mapper")
public class MplusApplication{

    public static void main(String[] args) {
        SpringApplication.run(MplusApplication.class, args);
    }

}
