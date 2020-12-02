package com.sam.anteass.common.service.sys.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sam.anteass.common.entity.sys.SysOrganUserPermission;
import com.sam.anteass.common.mapper.sys.SysOrganUserPermissionMapper;
import com.sam.anteass.common.service.sys.ISysOrganUserPermissionService;
import org.springframework.stereotype.Service;

@Service
public class SysOrganUserPermissionServiceImpl extends ServiceImpl<SysOrganUserPermissionMapper, SysOrganUserPermission> implements ISysOrganUserPermissionService {
}
