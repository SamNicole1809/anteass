package com.sam.anteass.common.service.sys.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sam.anteass.common.entity.sys.SysOrgan;
import com.sam.anteass.common.mapper.sys.SysOrganMapper;
import com.sam.anteass.common.service.sys.ISysOrganService;
import org.springframework.stereotype.Service;

@Service
public class SysOrganServiceImpl extends ServiceImpl<SysOrganMapper, SysOrgan> implements ISysOrganService {

    // 通过名字获取机构
    public SysOrgan getOrganByName(String organName) {
        return this.getOne(new QueryWrapper<SysOrgan>().lambda().eq(SysOrgan::getOrganName, organName));
    }

}
