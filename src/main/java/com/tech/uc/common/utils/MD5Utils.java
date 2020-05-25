package com.tech.uc.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author zhuyz
 * @date 2020/5/25 0025 19:51
 * @description
 */
public class MD5Utils {

    private static final String HASH_NAME = "MD5";

    /**
     * MD5密码加密
     *
     * @param password 原始密码
     * @param salt 盐值
     * @param hashIterations 加密次数
     * @return 加密后的密码
     */
    public static String getPwd(String password, String salt, int hashIterations) {
        SimpleHash hash = new SimpleHash(HASH_NAME, password, salt, hashIterations);
        return hash.toHex();
    }

}
