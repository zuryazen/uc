package com.tech.uc.mapper;

import com.tech.uc.entity.Org;
import com.tech.uc.entity.Role;
import com.tech.uc.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
public interface UserMapper extends BaseMapper<User> {

    List<User> findAllUser();

    /**
     * 根据用户名（登录名）获取用户信息（包含组织，角色的关联属性）
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 根据组织ID获取该组织下的用户列表
     * @param orgId
     * @return
     */
    List<User> findByOrgId(String orgId);


    List<User> findByCondition(Map condition);

    /**
     * 根据角色ID获取该角色下的用户列表
     * @param roleId
     * @return
     */
    List<User> findByRoleId(String roleId);

    /**
     * 根据组织ID和角色code获取用户列表
     * @param orgId
     * @param roleCode
     * @return
     */
    List<User> findByOrgIdAndRoleCode(@Param("orgId") String orgId, @Param("roleCode") String roleCode);

    /**
     * 删除组织用户关系列表
     * @param userId 用户ID
     */
    void deleteUserOrgList(String userId);

    /**
     * 删除用户角色关系列表
     * @param userId 用ID
     */
    void deleteUserRoleList(String userId);

    /**
     * 保存用户组织关联关系
     * @param userId
     * @param orgList
     */
    void insertUserOrgList(@Param("userId") String userId, @Param("orgList") List<Org> orgList);

    /**
     * 保存用户角色关联关系
     * @param userId
     * @param roleList
     */
    void insertUserRoleList(@Param("userId") String userId, @Param("roleList") List<Role> roleList);

    /**
     * 通过前台导入excel解析成list返回给后台，实现批量导入用户
     * @param users
     */
    void insertUsersByExcel(@Param("users") List<User> users);
}
