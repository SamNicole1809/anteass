package com.sam.anteass.common.utils;

public class AnteassConstant {

    // 分布式Id服务连接地址
    public static final String LEAF_URI = "http://193.168.1.200:8088/api/segment/get/anteass";

    // 全局ADMIN的默认ID
    public static final long ADMIN_ID = 0L;

    // 2天秒数
    public static final long DAY_2_SECOND = 60 * 60 * 24 * 2;

    // token失效时间
    public static final long TOKEN_EXPIRE = DAY_2_SECOND;

}
