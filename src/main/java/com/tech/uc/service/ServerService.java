package com.tech.uc.service;

import com.tech.uc.entity.Server;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
public interface ServerService extends IService<Server> {
    String getServerNameByUri(String uri);

    Map<String,String> getServerMapByUri(String uri);
}
