package com.tech.uc.service.impl;

import com.tech.uc.entity.Resource;
import com.tech.uc.mapper.ResourceMapper;
import com.tech.uc.service.ResourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    @Cacheable(cacheNames = "sys", keyGenerator = "keyGenerator")
    @Override
    public List<Resource> findByRoleId(String roleId) {
        return resourceMapper.findByRoleId(roleId);
    }

    @Cacheable(cacheNames = "sys", keyGenerator = "keyGenerator")
    @Override
    public List<Resource> findAll() {
        List<Resource> resourceList = resourceMapper.findAll();
        return resourceList;
    }

    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(cacheNames = "sys",allEntries = true)
    @Override
    public Resource insertRoleAndRescourde(Resource resource) {
        boolean b = super.insert(resource);
        if(b && !StringUtil.isNullOrEmpty(resource.getId())) {
            resourceMapper.insertRoleResource(resource);
        }
        return resource;
    }
}
