package com.ddz.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
* 这是程序启动的主入口
* */
@SpringBootApplication
@EnableScheduling
@EnableCaching //启动缓存 redis
@EnableTransactionManagement
@MapperScan("com.ddz.demo.dao")
public class DemoApplication {

    //项目的启动类
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
