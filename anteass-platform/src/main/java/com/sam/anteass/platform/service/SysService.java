package com.sam.anteass.platform.service;

import com.sam.anteass.common.entity.sys.*;
import com.sam.anteass.common.exception.AnteassDataExistedException;
import com.sam.anteass.common.exception.AnteassSqlException;
import com.sam.anteass.common.pojo.sys.SysOrganPara;
import com.sam.anteass.common.service.sys.impl.*;
import com.sam.anteass.common.utils.AnteassConstant;
import com.sam.anteass.common.utils.AnteassId;
import com.sam.anteass.common.utils.AnteassPassword;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class SysService {

    @Resource
    private SysOrganServiceImpl sysOrganService;
    @Resource
    private SysUserServiceImpl sysUserService;
    @Resource
    private SysRefOrganUserServiceImpl sysRefOrganUserService;
    @Resource
    private SysTeacherServiceImpl sysTeacherService;
    @Resource
    private SysRefOrganTeacherServiceImpl sysRefOrganTeacherService;

    @Transactional(rollbackFor = Exception.class)
    public void addOrgan(SysOrganPara para) throws Exception {
        // 机构是否存在
        SysOrgan sysOrgan = sysOrganService.getOrganByName(para.getOrganName());
        if (sysOrgan != null) {
            throw new AnteassDataExistedException("机构已存在");
        }
        // 添加机构
        sysOrgan = new SysOrgan();
        sysOrgan.setId(AnteassId.getId());
        sysOrgan.setOrganName(para.getOrganName());
        sysOrgan.setCreateTime(LocalDateTime.now());
        sysOrgan.setCreateUser(AnteassConstant.ADMIN_ID);
        boolean flag = sysOrganService.save(sysOrgan);
        if (!flag) {
            throw new AnteassSqlException();
        }
        // 添加人员
        // 人员不存在就创建，存在只添加机构用户关联
        SysUser sysUser = sysUserService.getUserByPhone(para.getPhone());
        String passwordEncry = AnteassPassword.encry(para.getPhone().substring(para.getPhone().length() - 6));
        if (sysUser == null) {
            sysUser = new SysUser();
            sysUser.setId(AnteassId.getId());
            sysUser.setUserPhone(para.getPhone());
            sysUser.setUserName(para.getNickName());
            sysUser.setUserPassword(passwordEncry);
            sysUser.setCreateUser(AnteassConstant.ADMIN_ID);
            sysUser.setCreateTime(LocalDateTime.now());
            flag = sysUserService.save(sysUser);
            if (!flag) {
                throw new AnteassSqlException();
            }
        }
        SysRefOrganUser sysRefOrganUser = new SysRefOrganUser();
        sysRefOrganUser.setId(AnteassId.getId());
        sysRefOrganUser.setOrganId(sysOrgan.getId());
        sysRefOrganUser.setOrganUserId(sysUser.getId());
        sysRefOrganUser.setCreateUser(AnteassConstant.ADMIN_ID);
        sysRefOrganUser.setCreateTime(LocalDateTime.now());
        flag = sysRefOrganUserService.save(sysRefOrganUser);
        if (!flag) {
            throw new AnteassSqlException();
        }
        // 添加老师
        // 老师不存在就创建，存在只添加机构老师关联
        SysTeacher sysTeacher = sysTeacherService.getTeacherByPhone(para.getPhone());
        if (sysTeacher == null) {
            sysTeacher = new SysTeacher();
            sysTeacher.setId(AnteassId.getId());
            sysTeacher.setTeacherPhone(para.getPhone());
            sysTeacher.setTeacherName(para.getNickName());
            sysTeacher.setTeacherPassword(passwordEncry);
            sysTeacher.setCreateTime(LocalDateTime.now());
            sysTeacher.setCreateUser(AnteassConstant.ADMIN_ID);
            flag = sysTeacherService.save(sysTeacher);
            if (!flag) {
                throw new AnteassSqlException();
            }
        }
        // 添加机构老师关联
        SysRefOrganTeacher sysRefOrganTeacher = new SysRefOrganTeacher();
        sysRefOrganTeacher.setId(AnteassId.getId());
        sysRefOrganTeacher.setOrganId(sysOrgan.getId());
        sysRefOrganTeacher.setTeacherId(sysTeacher.getId());
        sysRefOrganTeacher.setCreateTime(LocalDateTime.now());
        sysRefOrganTeacher.setCreateUser(AnteassConstant.ADMIN_ID);
        flag = sysRefOrganTeacherService.save(sysRefOrganTeacher);
        if (!flag) {
            throw new AnteassSqlException();
        }
    }

}
