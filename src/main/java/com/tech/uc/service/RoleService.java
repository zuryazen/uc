package com.tech.uc.service;

import com.github.pagehelper.PageInfo;
import com.tech.uc.entity.Resource;
import com.tech.uc.entity.Role;
import com.baomidou.mybatisplus.service.IService;
import com.tech.uc.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
public interface RoleService extends IService<Role> {
    /**
     * 角色资源关联保存
     *
     * 保存以下信息：
     *    <ul>
     *        <li>角色资源关联关系</li>
     *    </ul>
     */
    void saveRoleResources(String roleId, List<String> resourceIds);


    /**
     * 角色用户关联保存
     *
     * 保存以下信息：
     *    <ul>
     *        <li>角色用户关联关系</li>
     *    </ul>
     *
     */
    void saveRoleUsers(String roleId, List<String> userIds);

    /**
     * 根据组织Id获取该组织下角色列表
     * @param orgId
     * @return
     */
    List<Role> findListByOrgId(String orgId);


    /**
     * 根据用户ID获取该用户的角色列表
     * @param userId
     * @return
     */
    List<Role> findListByUserId(String userId);

    /**
     * 根据多个组织Id获取角色
     * @param orgIds
     * @return
     */
    List<Role> findListByOrgIds(List<String> orgIds);



    /**
     * 根据条件获取角色列表
     * @param params
     * @return
     */
    List<Role> findListByCondition(Map<String, Object> params);

    List<Resource> findByRoleId(String roleId);

    List<Role> findAll();

    PageInfo<Role> findAllRoleByPage(int pageNum, int pageSize);
}
