package com.sam.anteass.organization;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.sam.anteass.organization.mapper")
public class AnteassOrganizationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnteassOrganizationApplication.class);
    }
}
