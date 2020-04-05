package com.tech.uc.service;

import com.tech.uc.entity.Org;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
public interface OrgService extends IService<Org> {
    /**
     * 根据当前组织ID获取组织列表（树查询，包括当前组织和子集组织）
     * @param id
     * @param params
     * @return
     */
    List<Org> getAllOrgListById(String id, Map<String, Object> params);

    /**
     * 根据查询条件获取组织列表
     * @param params {
     *      pId --> 父级组织ID,
     *      fullName --> 组织全称, 支持模糊查询,
     *      code --> 组织编码
     *
     * }
     * @return
     */
    List<Org> getOrgListByCondition(Map<String, Object> params);

    /**
     * 根据用户Id获取所属组织列表
     * @param userId
     * @return
     */
    List<Org> getOrgListByUserId(String userId);


    /**
     * 根据组织机构编码获取唯一组织
     * @param code
     * @return
     */
    Org getByCode(String code);

    /**
     * 根据ID获取上级组织ID
     * @param id
     * @return
     */
    List<Org> getAllPOrgListById(String id);

}
