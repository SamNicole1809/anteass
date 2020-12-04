package com.sam.anteass.common.service.sys.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sam.anteass.common.dto.sys.ElementSelectDto;
import com.sam.anteass.common.entity.sys.SysRefOrganUser;
import com.sam.anteass.common.entity.sys.SysUser;
import com.sam.anteass.common.mapper.sys.SysRefOrganUserMapper;
import com.sam.anteass.common.service.sys.ISysRefOrganUserService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class SysRefOrganUserServiceImpl extends ServiceImpl<SysRefOrganUserMapper, SysRefOrganUser> implements ISysRefOrganUserService {

    // 获取用户所在机构
    public List<ElementSelectDto> getUserOrgans(SysUser sysUser) {
        List<Map<String, Object>> userOrgans = this.baseMapper.getUserOrganByUserId(sysUser.getId());
        List<ElementSelectDto> organs = new LinkedList<>();
        for (Map<String, Object> userOrgan : userOrgans) {
            ElementSelectDto organ = new ElementSelectDto();
            organ.setValue(Long.parseLong(userOrgan.get("organ_id").toString()));
            organ.setLabel(userOrgan.get("organ_name").toString());
            organs.add(organ);
        }
        return organs;
    }

    // 通过userId和organId获取记录
    public SysRefOrganUser getOneByUserIdAndOrganId(Long userId, Long organId) {
        return this.getOne(new QueryWrapper<SysRefOrganUser>().lambda().eq(SysRefOrganUser::getOrganId, organId).eq(SysRefOrganUser::getOrganUserId, userId));
    }

}
