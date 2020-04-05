package com.tech.uc.service.impl;

import com.github.pagehelper.Page;
import com.tech.uc.entity.Resource;
import com.tech.uc.entity.Role;
import com.tech.uc.entity.User;
import com.tech.uc.mapper.ResourceMapper;
import com.tech.uc.mapper.RoleMapper;
import com.tech.uc.service.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private ResourceMapper resourceMapper;


    @CacheEvict(cacheNames = "sys", allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveRoleResources(String roleId, List<Resource> resources) {

    }

    @CacheEvict(cacheNames = "sys", allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveRoleUsers(String roleId, List<User> users) {

    }

    @Cacheable(cacheNames = "sys", keyGenerator = "keyGenerator")
    @Override
    public List<Role> findListByOrgId(String orgId) {
        return null;
    }

    @Cacheable(cacheNames = "sys", keyGenerator = "keyGenerator")
    @Override
    public List<Role> findListByUserId(String userId) {
        return null;
    }

    @Cacheable(cacheNames = "sys", keyGenerator = "keyGenerator")
    @Override
    public List<Role> findListByOrgIds(List<String> orgIds) {
        return null;
    }

    @Cacheable(cacheNames = "sys", keyGenerator = "keyGenerator")
    @Override
    public List<Role> findListByCondition(Map<String, Object> params) {
        return null;
    }

    @Cacheable(cacheNames = "sys", keyGenerator = "keyGenerator")
    @Override
    public List<Resource> findByRoleId(String roleId) {
        return null;
    }

    @Cacheable(cacheNames = "sys", keyGenerator = "keyGenerator")
    @Override
    public List<Resource> findAll() {
        return null;
    }
}
