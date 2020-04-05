package com.tech.uc;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

/**
 * @author zhuyz
 * @date 2020/4/3 0003 22:44
 * @description
 */
public class MD5Test {


    @Test
    public void testMD5() {
        String hashName = "MD5";
        String pwd = "123456";

        SimpleHash hash = new SimpleHash(hashName, pwd, null, 2);
        System.out.println(hash.toString());
    }

}
