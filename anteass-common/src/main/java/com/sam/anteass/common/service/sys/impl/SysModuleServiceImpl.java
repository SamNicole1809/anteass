package com.sam.anteass.common.service.sys.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sam.anteass.common.entity.sys.SysModule;
import com.sam.anteass.common.mapper.sys.SysModuleMapper;
import com.sam.anteass.common.service.sys.ISysModuleService;
import org.springframework.stereotype.Service;

@Service
public class SysModuleServiceImpl extends ServiceImpl<SysModuleMapper, SysModule> implements ISysModuleService {
}
