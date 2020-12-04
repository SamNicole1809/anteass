package com.sam.anteass.organization.controller;

import com.sam.anteass.common.annotation.AnteassPermission;
import com.sam.anteass.common.entity.sys.SysUser;
import com.sam.anteass.common.exception.AnteassNotAllowedException;
import com.sam.anteass.common.exception.AnteassSqlException;
import com.sam.anteass.common.utils.AnteassId;
import com.sam.anteass.common.service.sys.impl.SysUserServiceImpl;
import com.sam.anteass.common.utils.AnteassPassword;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/")
public class TestController {

    @Resource
    private StringRedisTemplate rt;
    @Resource
    private SysUserServiceImpl sysUserService;

    @GetMapping("/redis")
    public String testRedis() {
        rt.opsForValue().set("123456", "123456");
        return "hello";
    }

    @AnteassPermission({"edu:edit", "edu:view"})
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
        return "OK";
    }

    @GetMapping("/exp")
    public String testException() throws Exception {
        throw new AnteassNotAllowedException();
    }

    @GetMapping("/leaf")
    public String getLeaf() {
        return AnteassId.getId().toString();
    }

    @GetMapping("/encry")
    public String encryTest() {
        System.out.println(AnteassPassword.valid("e10adc3949ba59abbe56e057f20f883e", "123456"));
        System.out.println(AnteassPassword.valid("e10adc3949ba59abbe56e057f20f883e", "654321"));
        return AnteassPassword.encry("123456");
    }

    @GetMapping("/request")
    public void getTest(Long id, String name) {
        System.out.println(id + "-" + name);
    }

    @PostMapping("/request")
    public void postTest(@RequestBody SysUser sysUser) {
        System.out.println(sysUser.getId());
        System.out.println(sysUser.getUserName());
    }

    @PutMapping("/request")
    public void putTest(@RequestBody SysUser sysUser) {
        System.out.println(sysUser.getId());
        System.out.println(sysUser.getUserName());
    }

    @DeleteMapping("/request")
    public void deleteTest(Long id) {
        System.out.println(id);
    }
}
