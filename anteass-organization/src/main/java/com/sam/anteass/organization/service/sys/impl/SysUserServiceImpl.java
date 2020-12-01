package com.sam.anteass.organization.service.sys.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sam.anteass.common.entity.sys.SysUser;
import com.sam.anteass.common.exception.AnteassSqlException;
import com.sam.anteass.organization.mapper.sys.SysUserMapper;
import com.sam.anteass.organization.service.sys.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    public void add(SysUser sysUser) throws AnteassSqlException{
        if (!this.save(sysUser)) {
            logger.error("add organ user error");
            throw new AnteassSqlException();
        }
    }

}
