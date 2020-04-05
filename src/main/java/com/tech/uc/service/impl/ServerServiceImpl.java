package com.tech.uc.service.impl;

import com.tech.uc.entity.Server;
import com.tech.uc.mapper.ServerMapper;
import com.tech.uc.service.ServerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public String getServerNameByUri(String uri) {
        return null;
    }

    @Override
    public Map<String, String> getServerMapByUri(String uri) {
        return null;
    }
}
