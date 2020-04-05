package com.tech.uc.mapper;

import com.tech.uc.entity.Resource;
import com.tech.uc.entity.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tech.uc.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据组织ID获取角色列表
     * @param orgId
     * @return
     */
    List<Role> findListByOrgId(String orgId);

    /**
     * 根据多个组织id获取角色列表
     * @param orgIds
     * @return
     */
    List<Role> findListByOrgIds(List<String> orgIds);

    /**
     * 根据用户ID获取该用户拥有的角色列表
     * @param userId
     * @return
     */
    List<Role> findListByUserId(String userId);

    /**
     * 保存角色资源关联关系列表
     * @param roleId
     * @param resourceList
     */
    void insertRoleResourceList(@Param("roleId") String roleId, @Param("resourceList") List<Resource> resourceList);

    /**
     * 删除角色资源关联关系
     * @param roleId
     */
    void delRoleResourceList(String roleId);

    /**
     * 删除角色用户关联关系
     * @param roleId
     */
    void delRoleUserList(String roleId);

    /**
     * 保存角色用户关联关系
     * @param roleId
     * @param userList
     */
    void insertRoleUserList(@Param("roleId") String roleId, @Param("userList") List<User> userList);

    /**
     * 根据条件获取角色列表
     * @param params
     * @return
     */
    List<Role> findListByCondition(Map<String, Object> params);
}
