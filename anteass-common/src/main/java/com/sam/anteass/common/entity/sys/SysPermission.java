package com.sam.anteass.common.entity.sys;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@TableName(value = "sys_permission")
public class SysPermission implements Serializable {

    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @TableField(value = "module_id")
    private Long moduleId;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
