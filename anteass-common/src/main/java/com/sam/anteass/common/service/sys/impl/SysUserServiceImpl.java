package com.sam.anteass.common.service.sys.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sam.anteass.common.entity.sys.SysUser;
import com.sam.anteass.common.mapper.sys.SysUserMapper;
import com.sam.anteass.common.service.sys.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    // 通过手机获取用户
    public SysUser getUserByPhone(String phone) {
        return this.getOne(new QueryWrapper<SysUser>().lambda().eq(SysUser::getUserPhone, phone));
    }

}
