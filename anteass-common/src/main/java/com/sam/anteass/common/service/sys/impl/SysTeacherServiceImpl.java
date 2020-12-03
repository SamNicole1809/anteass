package com.sam.anteass.common.service.sys.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sam.anteass.common.entity.sys.SysTeacher;
import com.sam.anteass.common.mapper.sys.SysTeacherMapper;
import com.sam.anteass.common.service.sys.ISysTeacherService;
import org.springframework.stereotype.Service;

@Service
public class SysTeacherServiceImpl extends ServiceImpl<SysTeacherMapper, SysTeacher> implements ISysTeacherService {

    // 通过手机号获取老师
    public SysTeacher getTeacherByPhone(String phone) {
        return this.getOne(new QueryWrapper<SysTeacher>().lambda().eq(SysTeacher::getTeacherPhone, phone));
    }

}
