package com.sam.anteass.organization;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.sam.anteass.common.*", "com.sam.anteass.organization.*"})
@MapperScan(value = "com.sam.anteass.common.mapper")
public class AnteassOrganizationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnteassOrganizationApplication.class);
    }
}
