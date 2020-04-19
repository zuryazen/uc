package com.tech.uc.conf;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author zhuyz
 * @date 2020/4/4 0004 13:16
 * @description
 */
public class CustomSesisonIdGenerator implements SessionIdGenerator {

    private static final String IDENTIFICATION = "UC";

    @Override
    public Serializable generateId(Session session) {
        return IDENTIFICATION + UUID.randomUUID().toString().replaceAll("-", "");
    }
}
