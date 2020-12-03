package com.sam.anteass.common.utils;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

public class PasswordUtils {

    // 加密
    public static String encry(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
    }

    // 验证
    public static boolean valid(String encry, String target) {
        if (encry == null || target == null) {
            throw new NullPointerException();
        }
        return DigestUtils.md5DigestAsHex(target.getBytes(StandardCharsets.UTF_8)).equals(encry);
    }

}
