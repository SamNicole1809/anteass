package com.sam.anteass.organization.service.sys.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sam.anteass.common.entity.sys.SysParent;
import com.sam.anteass.organization.mapper.sys.SysParentMapper;
import com.sam.anteass.organization.service.sys.ISysParentService;
import org.springframework.stereotype.Service;

@Service
public class SysParentServiceImpl extends ServiceImpl<SysParentMapper, SysParent> implements ISysParentService {
}
