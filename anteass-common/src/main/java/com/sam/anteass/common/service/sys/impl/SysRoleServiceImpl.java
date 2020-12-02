package com.sam.anteass.common.service.sys.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sam.anteass.common.entity.sys.SysRole;
import com.sam.anteass.common.mapper.sys.SysRoleMapper;
import com.sam.anteass.common.service.sys.ISysRoleService;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
}
