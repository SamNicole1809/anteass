package com.sam.anteass.organization.service;

import com.sam.anteass.common.auth.AnteassAuth;
import com.sam.anteass.common.auth.AnteassTokenType;
import com.sam.anteass.common.dto.sys.ElementSelectDto;
import com.sam.anteass.common.entity.sys.SysRefOrganUser;
import com.sam.anteass.common.entity.sys.SysUser;
import com.sam.anteass.common.exception.AnteassCommonException;
import com.sam.anteass.common.exception.AnteassForbiddenException;
import com.sam.anteass.common.exception.AnteassNotFoundException;
import com.sam.anteass.common.exception.AnteassSqlException;
import com.sam.anteass.common.pojo.sys.SysLoginPara;
import com.sam.anteass.common.pojo.sys.SysUserRedis;
import com.sam.anteass.common.service.sys.impl.SysRefOrganUserServiceImpl;
import com.sam.anteass.common.service.sys.impl.SysUserServiceImpl;
import com.sam.anteass.common.utils.AnteassPassword;
import com.sam.anteass.organization.dto.sys.SysLoginDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SysService {

    @Resource
    private SysUserServiceImpl sysUserService;
    @Resource
    private SysRefOrganUserServiceImpl sysRefOrganUserService;
    @Resource
    private AnteassAuth anteassAuth;

    // 验证用户
    public SysUser validUser(SysLoginPara para) throws Exception {
        // 查询用户
        SysUser sysUser = sysUserService.getUserByPhone(para.getPhone());
        if (sysUser == null) {
            throw new AnteassNotFoundException("用户不存在");
        }
        // 验证密码
        if (!AnteassPassword.valid(sysUser.getUserPassword(), para.getPassword())) {
            throw new AnteassCommonException("密码错误");
        }
        return sysUser;
    }

    // 用户登录
    public SysLoginDto userLogin(SysLoginPara para) throws Exception {
        SysUser sysUser = this.validUser(para);
        List<ElementSelectDto> organs = sysRefOrganUserService.getUserOrgans(sysUser);
        String token = anteassAuth.buildToken(sysUser.getId(), AnteassTokenType.ANTEASS_WEB.getType());
        anteassAuth.removeToken(sysUser, AnteassTokenType.ANTEASS_WEB.getType());
        anteassAuth.build2RedisOnlyUserId(token, sysUser);
        SysLoginDto sysLoginDto = new SysLoginDto();
        sysLoginDto.setToken(token);
        sysLoginDto.setOrgans(organs);
        return sysLoginDto;
    }

    // 用户退出
    public void userLogout(HttpServletRequest request) {
        anteassAuth.removeToken(request);
    }

    // 用户权限
    public SysUserRedis userAuth(SysLoginPara para) throws Exception {
        // 获取用户
        Long userId = anteassAuth.getUserId(para.getToken());
        if (userId == null) {
            throw new AnteassForbiddenException();
        }
        SysUser sysUser = sysUserService.getById(userId);
        if (sysUser == null) {
            throw new AnteassForbiddenException();
        }
        // 获取机构用户
        SysRefOrganUser sysRefOrganUser = sysRefOrganUserService.getOneByUserIdAndOrganId(sysUser.getId(), para.getOrganId());
        if (sysRefOrganUser == null) {
            throw new AnteassNotFoundException("机构用户不存在");
        }
        // 刷新redis
        SysUserRedis sysUserRedis = new SysUserRedis();
        sysUserRedis.setUserId(sysUser.getId());
        sysUserRedis.setOrganId(sysRefOrganUser.getOrganId());
        sysUserRedis.setUserName(sysUser.getUserName());
        sysUserRedis.setAvatar(null);
        sysUserRedis.setOrganUserId(sysRefOrganUser.getId());
        // TODO: 2020/12/4 暂时统一返回admin权限
        sysUserRedis.setPermission(Collections.singletonList("admin"));
        anteassAuth.build2Redis(para.getToken(), sysUserRedis);
        sysUserRedis.setToken(para.getToken());
        return sysUserRedis;
    }

    public SysUserRedis userInfo(String token) {
        return anteassAuth.getSysUserRedis(token);
    }

}
