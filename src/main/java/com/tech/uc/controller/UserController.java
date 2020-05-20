package com.tech.uc.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageInfo;
import com.tech.uc.common.utils.JwtUtils;
import com.tech.uc.common.utils.RedisClient;
import com.tech.uc.common.utils.ResponseEntity;
import com.tech.uc.entity.Resource;
import com.tech.uc.entity.Role;
import com.tech.uc.entity.User;
import com.tech.uc.service.RoleService;
import com.tech.uc.service.UserService;
import com.tech.uc.vo.UserIdRolesVO;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.tech.uc.common.constant.Constant.Auth.AUTHORIZATION;
import static com.tech.uc.common.constant.Constant.Auth.AUTHORIZATIONINFO;
import static com.tech.uc.common.constant.Constant.StatusCode.*;
import static com.tech.uc.controller.PublicController.getMD5SimpleHash;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RedisClient redisClient;

    /**
     * 分页查询用户列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequiresPermissions("user:view")
    @GetMapping("/findAll/{pageNum}/{pageSize}")
    public ResponseEntity<PageInfo<User>> findAllUser(
            @PathVariable("pageNum") Integer pageNum,
            @PathVariable("pageSize") Integer pageSize, HttpServletRequest request) {
        PageInfo<User> userPageInfos = userService.findAllUserByPage(pageNum, pageSize);
        return ResponseEntity.buildSuccess(userPageInfos);
    }

    @RequiresPermissions("user:view")
    @GetMapping("/findUser/{id}")
    public ResponseEntity findUserById(@PathVariable("id") String id) {
        User user = userService.selectById(id);
        user.setPassword("");
        if (user != null) {
            return ResponseEntity.buildSuccess(user);
        } else {
            return ResponseEntity.buildCustom(USER_NOT_FOUND);
        }
    }

    @RequiresRoles(value = {"101", "100", "000"}, logical = Logical.OR)
    @GetMapping("/findRolesByUserId/{id}/{pageNum}/{pageSize}")
    public ResponseEntity findRolesByUserId(
            @PathVariable("id") String id,
            @PathVariable("pageNum") Integer pageNum,
            @PathVariable("pageSize") Integer pageSize) {
        PageInfo<Role> allRoleByPage = roleService.findAllRoleByPage(pageNum, pageSize);
        List<Role> curUserRoles = roleService.findListByUserId(id);
        Map<String, Object> data = new HashMap<>();
        data.put("allRoles", allRoleByPage);
        data.put("curUserRoles", curUserRoles);
        return ResponseEntity.buildSuccess(data);
    }


    /**
     * 根据用户id删除用户
     *
     * @param id
     * @return
     */
    @RequiresPermissions("user:delete")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") String id) {
        userService.deleteUserById(id);
        Integer pageTotal = userService.selectCount(new EntityWrapper<>());
        return ResponseEntity.buildSuccess(pageTotal);
    }


    /**
     * 根据用户id更新是否启用开关
     *
     * @param user
     * @return
     */
    @RequiresPermissions("user:update")
    @PutMapping("/update")
    public ResponseEntity updateUserById(@RequestBody User user) {
        boolean b = userService.updateById(user);
        return b ? ResponseEntity.buildSuccess(user)
                : ResponseEntity.buildCustom(user, UPDATE_ERROR);
    }

    /**
     * 根据用户id更新用户
     *
     * @param id
     * @param status
     * @return
     */
    @RequiresPermissions("user:update")
    @PutMapping("/updateStatus/{id}/{status}")
    public ResponseEntity updateUserOpenById(@PathVariable("id") String id, @PathVariable("status") Integer status) {
        User user = userService.selectById(id);
        user.setStatus(status);
        return userService.updateById(user) ? ResponseEntity.buildSuccess() : ResponseEntity.buildCustom(UPDATE_ERROR);
    }

    @RequiresRoles(value = {"101", "100", "000"}, logical = Logical.OR)
    @PutMapping("updateUserRoles")
    public ResponseEntity updateUserRoles(@RequestBody UserIdRolesVO userIdRolesVO) {
        String userId = userIdRolesVO.getUserId();
        List<Role> roleList = userIdRolesVO.getRoleList();
        List<String> roleIds = roleList.stream().map(Role::getId).collect(Collectors.toList());
        userService.updateUserRole(userId, roleIds);
        return ResponseEntity.buildSuccess();
    }


}

