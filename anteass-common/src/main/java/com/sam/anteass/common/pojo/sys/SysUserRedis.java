package com.sam.anteass.common.pojo.sys;

import java.util.List;

public class SysUserRedis {
    private Long userId;
    private String token;
    private String userName;
    private String avatar;
    private Long organId;
    private Long organUserId;
    private List<String> permission;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getOrganId() {
        return organId;
    }

    public void setOrganId(Long organId) {
        this.organId = organId;
    }

    public Long getOrganUserId() {
        return organUserId;
    }

    public void setOrganUserId(Long organUserId) {
        this.organUserId = organUserId;
    }

    public List<String> getPermission() {
        return permission;
    }

    public void setPermission(List<String> permission) {
        this.permission = permission;
    }
}
