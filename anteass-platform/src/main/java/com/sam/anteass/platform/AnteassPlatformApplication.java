package com.sam.anteass.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.sam.anteass.common.*", "com.sam.anteass.platform.*"})
@MapperScan(value = "com.sam.anteass.common.mapper")
public class AnteassPlatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnteassPlatformApplication.class);
    }
}
