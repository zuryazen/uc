package com.tech.uc.service.impl;

import com.github.pagehelper.Page;
import com.tech.uc.entity.Org;
import com.tech.uc.mapper.OrgMapper;
import com.tech.uc.service.OrgService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements OrgService {
    @Autowired
    private OrgMapper orgMapper;

    @Cacheable(cacheNames = "sys", keyGenerator = "keyGenerator")
    @Override
    public List<Org> getAllOrgListById(String id, Map<String, Object> params) {
        if (id == null) {
            throw new RuntimeException("id cannot be null. ");
        }
        return orgMapper.getAllOrgListById(id);
    }

    @Cacheable(cacheNames = "sys", keyGenerator = "keyGenerator")
    @Override
    public List<Org> getOrgListByCondition(Map<String, Object> params) {
        return orgMapper.getOrgListByCondition(params);
    }

    @Cacheable(cacheNames = "sys", keyGenerator = "keyGenerator")
    @Override
    public List<Org> getOrgListByUserId(String userId) {
        return orgMapper.getOrgListByUserId(userId);
    }

    @Cacheable(cacheNames = "sys", keyGenerator = "keyGenerator")
    @Override
    public Org getByCode(String code) {
        return orgMapper.getByCode(code);
    }

    @Cacheable(cacheNames = "sys", keyGenerator = "keyGenerator")
    @Override
    public List<Org> getAllPOrgListById(String id) {
        return orgMapper.getAllPOrgListById(id);
    }


}
