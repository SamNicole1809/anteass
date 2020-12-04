package com.sam.anteass.common.utils;

public enum AnteassReturnEnum {

    SUCCESS("200"),
    FORBIDDEN("403"),
    NOT_ALLOWED("405"),
    SERVER_ERROR("500"),
    PARAM_ERROR("406"),
    NOT_FOUND("404")
    ;

    private String code;

    AnteassReturnEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
