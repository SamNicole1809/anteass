package com.sam.anteass.common.utils;

import org.springframework.web.client.RestTemplate;

public class AnteassId {

    public static Long getId() {
        return new RestTemplate().getForEntity(AnteassConstant.LEAF_URI, Long.class).getBody();
    }

}
