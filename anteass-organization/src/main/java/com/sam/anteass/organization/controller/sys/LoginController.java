package com.sam.anteass.organization.controller.sys;

import com.sam.anteass.common.exception.AnteassParamException;
import com.sam.anteass.common.pojo.sys.SysLoginPara;
import com.sam.anteass.common.pojo.sys.SysUserRedis;
import com.sam.anteass.common.utils.AnteassLong;
import com.sam.anteass.common.utils.AnteassReturn;
import com.sam.anteass.common.utils.AnteassString;
import com.sam.anteass.organization.dto.sys.SysLoginDto;
import com.sam.anteass.organization.service.SysService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/sys")
public class LoginController {

    @Resource
    private SysService sysService;

    @PostMapping("/user/auth")
    public String userAuth(@RequestBody SysLoginPara para) throws Exception {
        if (AnteassString.isNullOrEmpty(para.getToken())) {
            throw new AnteassParamException();
        }
        if (AnteassLong.isNotId(para.getOrganId())) {
            throw new AnteassParamException();
        }
        return AnteassReturn.ok(sysService.userAuth(para));
    }

    @PostMapping("/user/info")
    public String userInfo(@RequestBody SysLoginPara para) throws Exception {
        if (AnteassString.isNullOrEmpty(para.getToken())) {
            throw new AnteassParamException();
        }
        SysUserRedis sysUserRedis = sysService.userInfo(para.getToken());
        return AnteassReturn.ok(sysUserRedis);
    }

    @PostMapping("/user/login")
    public String userLogin(@RequestBody SysLoginPara para) throws Exception {
        return AnteassReturn.ok("OK", sysService.userLogin(para));
    }

    @GetMapping("/user/logout")
    public String userLogout(HttpServletRequest request) {
        sysService.userLogout(request);
        return AnteassReturn.ok();
    }

}
