package com.tech.uc.service.impl;

import com.tech.uc.entity.Server;
import com.tech.uc.mapper.ServerMapper;
import com.tech.uc.service.ServerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ServerServiceImpl extends ServiceImpl<ServerMapper, Server> implements ServerService {

    @Autowired
    private ServerMapper serverMapper;

    @Cacheable(cacheNames = "sys", keyGenerator = "keyGenerator")
    @Override
    public String getServerNameByUri(String uri) {
        return serverMapper.getServerNameByUri(uri);
    }

    @Cacheable(cacheNames = "sys", keyGenerator = "keyGenerator")
    @Override
    public Map<String, String> getServerMapByUri(String uri) {
        List<Server> serverList = serverMapper.getServerListByUri(uri);
        Map<String, String> serverMap = new HashMap<>(5);

        for (Server item : serverList) {
            serverMap.put(item.getProjectNo(), item.getUri());
        }
        return serverMap;
    }

}
