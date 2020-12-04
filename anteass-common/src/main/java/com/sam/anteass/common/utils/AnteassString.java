package com.sam.anteass.common.utils;

import java.util.Random;

public class AnteassString {

    public static String get6RandomChar() {
        StringBuilder chars = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int index = new Random().nextInt(26) + 65;
            chars.append((char) index);
        }
        return chars.toString();
    }

    public static boolean isNullOrEmpty(String val) {
        return val == null || "".equals(val.trim());
    }

    public static boolean isNotNullAndEmpty(String val) {
        return val != null && !"".equals(val.trim());
    }

}
