package com.sam.anteass.organization.service.sys.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sam.anteass.common.entity.sys.SysOrgan;
import com.sam.anteass.organization.mapper.sys.SysOrganMapper;
import com.sam.anteass.organization.service.sys.ISysOrganService;
import org.springframework.stereotype.Service;

@Service
public class SysOrganServiceImpl extends ServiceImpl<SysOrganMapper, SysOrgan> implements ISysOrganService {
}
