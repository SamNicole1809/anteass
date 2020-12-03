package com.sam.anteass.common.service.sys.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sam.anteass.common.entity.sys.SysRefOrganUser;
import com.sam.anteass.common.mapper.sys.SysRefOrganUserMapper;
import com.sam.anteass.common.service.sys.ISysRefOrganUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysRefOrganUserServiceImpl extends ServiceImpl<SysRefOrganUserMapper, SysRefOrganUser> implements ISysRefOrganUserService {

    // 获取用户所在的机构
    // [{organ_id, organ_name}...]
    public List<Map<String, Object>> getUserOrganByUserId(Long userId) {
        return this.baseMapper.getUserOrganByUserId(userId);
    }

}
