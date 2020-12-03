package com.sam.anteass.organization.controller.sys;

import com.sam.anteass.common.pojo.sys.SysLoginPara;
import com.sam.anteass.common.utils.AnteassReturn;
import com.sam.anteass.organization.dto.sys.SysLoginDto;
import com.sam.anteass.organization.service.SysService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sys")
public class LoginController {

    @Resource
    private SysService sysService;

    @PostMapping("/user/login")
    public String userLogign(@RequestBody SysLoginPara para) {
        return null;
    }

    @PostMapping("/user/organ")
    public String getOrgans(@RequestBody SysLoginPara para) throws Exception {
        SysLoginDto sysLoginDto = sysService.getOrgans(para);
        return AnteassReturn.ok("OK", sysLoginDto);
    }

}
