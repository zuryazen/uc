package com.tech.uc.service;

import com.github.pagehelper.PageInfo;
import com.tech.uc.entity.Resource;
import com.baomidou.mybatisplus.service.IService;
import com.tech.uc.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
public interface ResourceService extends IService<Resource> {
    /**
     * 根据角色ID获取该角色下资源列表
     * @param roleId
     * @return
     */
    List<Resource> findByRoleId(String roleId);

    List<Resource> findAll();



    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(cacheNames = "sys",allEntries = true)
    Resource insertRoleAndRescourde(Resource resource);
}
