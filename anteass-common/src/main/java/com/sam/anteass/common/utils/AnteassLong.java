package com.sam.anteass.common.utils;

public class AnteassLong {

    public static boolean isNull(Long l) {
        return l == null;
    }

    public static boolean isNotId(Long l) {
        return isNull(l) || l < 0L;
    }

}
