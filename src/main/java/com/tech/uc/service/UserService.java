package com.tech.uc.service;

import com.github.pagehelper.PageInfo;
import com.tech.uc.entity.Resource;
import com.tech.uc.entity.User;
import com.baomidou.mybatisplus.service.IService;

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
public interface UserService extends IService<User> {

    /**
     * 保存用户（新增，修改，由主键是否为空决定，为空表示新增，否则修改）
     *
     *  保存以下信息：
     *      用户基本信息
     *      用户组织关联关系
     *      用户角色关联关系
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 删除用户
     *   删除用户组织关联关系
     *   删除用户角色关联关系
     *   删除用户信息
     *
     * @param id
     */
    void deleteUserById(String id);

    /**
     * 根据用户名（登录名）获取用户信息（包含关联组织，角色，权限）
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 根据组织ID获取组织下的用户列表
     * @param orgId
     * @return
     */
    List<User> findByOrgId(String orgId);

    /**
     * 根据组织ID获取组织下的用户列表
     * @param condition
     * @return
     */
    List<User> findByCondition(Map condition);

    /**
     * 根据组织ID和角色code获取用户列表
     * @param orgId
     * @param roleCode
     * @return
     */
    List<User> findByOrgIdAndRoleCode(String orgId, String roleCode);


    /**
     * 根据角色ID获取角色下的用户列表
     * @param roleId
     * @return
     */
    List<User> findByRoleId(String roleId);

    /**
     * 根据用户名和密码获取用户信息
     * @param username
     * @param password
     * @return
     */
    Map<String, Object> findByUsernameAndPassword(String username, String password);

    /**
     * 根据当前页和页数获取用户列表(分页)
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<User> findAllUserByPage(int pageNum, int pageSize);

    /**
     * 根据token获取redis缓存中的user.munus
     * @param token
     * @return
     */
    List<Resource> getMenus(String token);


}
