package com.tech.uc.service.impl;

import com.baomidou.mybatisplus.service.IService;
import com.tech.uc.entity.DictGroup;
import com.tech.uc.mapper.DictGroupMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tech.uc.mapper.DictItemMapper;
import com.tech.uc.service.DictGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

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
public class DictGroupServiceImpl extends ServiceImpl<DictGroupMapper, DictGroup> implements DictGroupService {


    @Autowired
    private DictGroupMapper dictGroupMapper;


    @Cacheable(cacheNames = "dict", keyGenerator = "keyGenerator")
    @Override
    public List<DictGroup> getAll() {
        return dictGroupMapper.getAll();
    }



}
