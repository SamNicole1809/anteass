package com.sam.anteass.organization.controller;

import com.sam.anteass.common.annotation.AnteassPermission;
import com.sam.anteass.common.entity.sys.SysUser;
import com.sam.anteass.common.exception.AnteassNotAllowedException;
import com.sam.anteass.common.exception.AnteassSqlException;
import com.sam.anteass.organization.service.sys.impl.SysUserServiceImpl;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/")
public class TestController {

    @Resource
    private StringRedisTemplate rt;
    @Resource
    private SysUserServiceImpl sysUserService;

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

    @GetMapping("/user")
    public String testUser() throws AnteassSqlException {
        SysUser sysUser = new SysUser();
        sysUser.setId(1L);
        sysUser.setCreateUser(0L);
        sysUser.setActive(true);
        sysUser.setUserName("sam");
        sysUser.setUserPassword("123");
        sysUser.setUserPhone("18353232271");
        sysUser.setCreateTime(LocalDateTime.now());
        sysUserService.add(sysUser);
        return "OK";
    }

    @GetMapping("/exp")
    public String testException() throws Exception {
        throw new AnteassNotAllowedException();
    }
}
