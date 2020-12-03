package com.sam.anteass.organization.service;

import com.sam.anteass.common.dto.sys.ElementSelectDto;
import com.sam.anteass.common.entity.sys.SysUser;
import com.sam.anteass.common.exception.AnteassCommonException;
import com.sam.anteass.common.exception.AnteassNotFoundException;
import com.sam.anteass.common.pojo.sys.SysLoginPara;
import com.sam.anteass.common.service.sys.impl.SysRefOrganUserServiceImpl;
import com.sam.anteass.common.service.sys.impl.SysUserServiceImpl;
import com.sam.anteass.common.utils.PasswordUtils;
import com.sam.anteass.organization.dto.sys.SysLoginDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class SysService {

    @Resource
    private SysUserServiceImpl sysUserService;
    @Resource
    private SysRefOrganUserServiceImpl sysRefOrganUserService;

    public SysLoginDto getOrgans(SysLoginPara para) throws Exception {
        // 查询用户
        SysUser sysUser = sysUserService.getUserByPhone(para.getPhone());
        if (sysUser == null) {
            throw new AnteassNotFoundException("用户不存在");
        }
        // 验证密码
        if (!PasswordUtils.valid(sysUser.getUserPassword(), para.getPassword())) {
            throw new AnteassCommonException("密码错误");
        }
        // 返回机构
        List<Map<String, Object>> userOrgans = sysRefOrganUserService.getUserOrganByUserId(sysUser.getId());
        List<ElementSelectDto> organs = new LinkedList<>();
        for (Map<String, Object> userOrgan : userOrgans) {
            ElementSelectDto organ = new ElementSelectDto();
            organ.setValue(Long.parseLong(userOrgan.get("organ_id").toString()));
            organ.setLabel(userOrgan.get("organ_name").toString());
        }
        SysLoginDto sysLoginDto = new SysLoginDto();
        sysLoginDto.setOrgans(organs);
        return sysLoginDto;
    }

}
