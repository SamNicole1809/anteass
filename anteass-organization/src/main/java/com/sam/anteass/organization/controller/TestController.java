package com.sam.anteass.organization.controller;

import com.sam.anteass.common.annotation.AnteassPermission;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/")
public class TestController {

    @Resource
    private StringRedisTemplate rt;

    @AnteassPermission({"edu:edit", "edu:view"})
    @GetMapping("/redis")
    public String testRedis() {
        rt.opsForValue().set("123456", "123456");
        return "hello";
    }

    @GetMapping("/mysql")
    public String testMysql() {
        return "mysql";
    }
}
