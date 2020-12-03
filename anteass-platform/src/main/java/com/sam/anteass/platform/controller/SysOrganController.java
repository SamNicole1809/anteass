package com.sam.anteass.platform.controller;

import com.sam.anteass.common.pojo.sys.SysOrganPara;
import com.sam.anteass.common.utils.AnteassReturn;
import com.sam.anteass.platform.service.SysService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sys")
public class SysOrganController {

    @Resource
    private SysService sysService;

    @PostMapping("/organ")
    public String addSysOrgan(@RequestBody SysOrganPara para) throws Exception {
        // todo check para
        sysService.addOrgan(para);
        return AnteassReturn.ok();
    }

}
