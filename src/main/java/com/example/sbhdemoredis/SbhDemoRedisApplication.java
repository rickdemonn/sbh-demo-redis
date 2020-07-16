package com.example.sbhdemoredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SbhDemoRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbhDemoRedisApplication.class, args);
    }

}
