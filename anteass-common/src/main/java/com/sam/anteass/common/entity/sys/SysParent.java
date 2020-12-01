package com.sam.anteass.common.entity.sys;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@TableName(value = "sys_parent")
public class SysParent implements Serializable {

    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @TableField(value = "parent_name")
    private String parentName;

    @TableField(value = "parent_phone")
    private String parentPhone;

    @TableField(value = "parent_password")
    private String parentPassword;

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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    public String getParentPassword() {
        return parentPassword;
    }

    public void setParentPassword(String parentPassword) {
        this.parentPassword = parentPassword;
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
