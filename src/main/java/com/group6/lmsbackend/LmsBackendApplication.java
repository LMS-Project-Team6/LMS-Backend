package com.group6.lmsbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.group6.lmsbackend.mapper")
public class LmsBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(LmsBackendApplication.class, args);
    }
}
