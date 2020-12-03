package com.sam.anteass.organization.dto.sys;

import com.sam.anteass.common.dto.sys.ElementSelectDto;

import java.util.List;

public class SysLoginDto {
    private String token;
    private List<ElementSelectDto> organs;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<ElementSelectDto> getOrgans() {
        return organs;
    }

    public void setOrgans(List<ElementSelectDto> organs) {
        this.organs = organs;
    }
}
