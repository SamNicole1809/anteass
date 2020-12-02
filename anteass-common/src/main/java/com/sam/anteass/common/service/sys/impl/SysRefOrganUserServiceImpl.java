package com.sam.anteass.common.service.sys.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sam.anteass.common.entity.sys.SysRefOrganUser;
import com.sam.anteass.common.mapper.sys.SysRefOrganUserMapper;
import com.sam.anteass.common.service.sys.ISysRefOrganUserService;
import org.springframework.stereotype.Service;

@Service
public class SysRefOrganUserServiceImpl extends ServiceImpl<SysRefOrganUserMapper, SysRefOrganUser> implements ISysRefOrganUserService {
}
