package com.sam.anteass.common.entity.sys;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@TableName(value = "sys_role")
public class SysRole implements Serializable {

    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @TableField(value = "role_name")
    private String roleName;

    @TableField(value = "permission_code")
    private String permissionCode;

    @TableField(value = "is_active")
    private Boolean active;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "modify_time")
    private LocalDateTime modifyTime;

    @TableField(value = "create_user")
    private Long createUser;

    @TableField(value = "modify_user")
    private Long modifyUser;

    @Version
    @TableField(value = "version")
    private Long version;

}
