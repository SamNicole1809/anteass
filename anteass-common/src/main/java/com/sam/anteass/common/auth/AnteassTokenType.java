package com.sam.anteass.common.auth;

public enum AnteassTokenType {
    ANTEASS_WEB("ORGAN"),
    ;

    private String type;

    AnteassTokenType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
