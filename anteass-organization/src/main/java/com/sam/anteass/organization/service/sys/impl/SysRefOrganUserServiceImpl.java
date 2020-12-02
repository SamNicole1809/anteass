package com.sam.anteass.organization.service.sys.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sam.anteass.common.entity.sys.SysRefOrganUser;
import com.sam.anteass.organization.mapper.sys.SysRefOrganUserMapper;
import com.sam.anteass.organization.service.sys.ISysRefOrganUserService;
import org.springframework.stereotype.Service;

@Service
public class SysRefOrganUserServiceImpl extends ServiceImpl<SysRefOrganUserMapper, SysRefOrganUser> implements ISysRefOrganUserService {
}
