package com.zhuyz.adminuser.conf;

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

    @Override
    public Serializable generateId(Session session) {
        return "zhuyz" + UUID.randomUUID().toString().replaceAll("-", "");
    }
}
