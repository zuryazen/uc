package com.zhuyz.adminuser.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuyz.adminuser.entity.User;
import com.zhuyz.adminuser.mapper.UserMapper;
import com.zhuyz.adminuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

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
    public Integer updateUserSwitchById(Integer id ,boolean isSwitch) {
        return userMapper.updateUserSwitchById(id, isSwitch);
    }


}
