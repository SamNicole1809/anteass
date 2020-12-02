package com.sam.anteass.common.service.edu.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sam.anteass.common.entity.edu.EduClass;
import com.sam.anteass.common.mapper.edu.EduClassMapper;
import com.sam.anteass.common.service.edu.IEduClassService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author anteass
 * @since 2020-12-02
 */
@Service
public class EduClassServiceImpl extends ServiceImpl<EduClassMapper, EduClass> implements IEduClassService {
}
