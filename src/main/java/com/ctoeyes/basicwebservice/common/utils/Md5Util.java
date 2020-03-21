package com.ctoeyes.basicwebservice.common.utils;

import org.springframework.util.DigestUtils;

public class Md5Util {
    /**
     * MD5加密
     */
    public static String encryption(String data) {
        return DigestUtils.md5DigestAsHex(data.getBytes());
    }
}
