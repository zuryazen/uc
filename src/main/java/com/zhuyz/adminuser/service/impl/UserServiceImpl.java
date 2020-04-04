package com.zhuyz.adminuser.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuyz.adminuser.entity.Role;
import com.zhuyz.adminuser.entity.User;
import com.zhuyz.adminuser.entity.UserRole;
import com.zhuyz.adminuser.mapper.RoleMapper;
import com.zhuyz.adminuser.mapper.UserMapper;
import com.zhuyz.adminuser.mapper.UserRoleMapper;
import com.zhuyz.adminuser.service.IUserRoleService;
import com.zhuyz.adminuser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public PageInfo<User> findAllUserByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.findAllUser();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }


    @Override
    public Integer countAllUser() {
        return userMapper.countAllUser();
    }


    @Override
    public Integer deleteUserById(Integer id) {
        Integer state = userMapper.deleteUeserById(id);
        return state;
    }

    @Override
    public Integer updateUserById(User user) {
        return userMapper.updateUserById(user);
    }

    @Override
    public Integer updateUserOpenById(Integer id ,boolean isSwitch) {
        return userMapper.updateUserOpenById(id, isSwitch);
    }

    @Override
    public User findAllUserInfoByUserId(Integer userId) {
        User user = userMapper.findUserById(userId);
        List<Role> roleListByUserId = roleMapper.findRoleListByUserId(user.getId());
        user.setRoleList(roleListByUserId);
        return user;
    }

    @Override
    public User findAllUserInfoByUsername(String name) {
        User user = userMapper.findUserByUsername(name);
        List<Role> roleListByUserId = roleMapper.findRoleListByUserId(user.getId());
        user.setRoleList(roleListByUserId);
        return user;
    }

}
