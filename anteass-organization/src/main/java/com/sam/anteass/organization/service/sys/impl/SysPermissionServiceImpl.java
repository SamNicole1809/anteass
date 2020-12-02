package com.sam.anteass.organization.service.sys.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sam.anteass.common.entity.sys.SysPermission;
import com.sam.anteass.organization.mapper.sys.SysPermissionMapper;
import com.sam.anteass.organization.service.sys.ISysPermissionService;
import org.springframework.stereotype.Service;

@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {
}
