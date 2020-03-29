package com.zhuyz.admin_user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuyz.admin_user.entity.User;
import com.zhuyz.admin_user.mapper.UserMapper;
import com.zhuyz.admin_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public Integer updateUesrById(User user) {
        return userMapper.updateUesrById(user);
    }


}
