package com.sam.anteass.common.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sam.anteass.common.entity.sys.SysRefOrganUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface SysRefOrganUserMapper extends BaseMapper<SysRefOrganUser> {

    @Select("select srou.organ_id, so.organ_name from sys_ref_organ_user srou\n" +
            "left join sys_organ so on srou.organ_id = so.id\n" +
            "where srou.organ_user_id = #{userId};")
    List<Map<String, Object>> getUserOrganByUserId(Long userId);

}
