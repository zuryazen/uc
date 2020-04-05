package com.tech.uc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tech.uc.entity.Role;
import com.tech.uc.entity.User;
import com.tech.uc.mapper.RoleMapper;
import com.tech.uc.mapper.UserMapper;
import com.tech.uc.service.DictGroupService;
import com.tech.uc.service.DictItemService;
import com.tech.uc.service.OrgService;
import com.tech.uc.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private OrgService orgService;

    @Autowired
    private DictGroupService dictGroupService;

    @Autowired
    private DictItemService dictItemService;

    @CacheEvict(cacheNames = "sys", allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveUser(User user) {

    }

    @CacheEvict(cacheNames = "sys", allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteUser(User user) {

    }

    @Override
    public User findByUsername(String username, String uri) {
        return null;
    }

    @Override
    public List<User> findByOrgId(String orgId) {
        return null;
    }

    @Override
    public List<User> findByCondition(Map condition) {
        return null;
    }

    @Override
    public List<User> findByOrgIdAndRoleCode(String orgId, String roleCode) {
        return null;
    }

    @Override
    public List<User> findByRoleId(String roleId) {
        return null;
    }

    @Override
    public Map<String, Object> findByUsernameAndPassword(String username, String password) {
        return null;
    }
}
