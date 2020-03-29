package com.zhuyz.adminuser.service;

import com.github.pagehelper.PageInfo;
import com.zhuyz.adminuser.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();

    PageInfo<User> findAllUserByPage(int pageNum, int pageSize);

    User findUserById(Integer id);

    Integer countAllUser();

    Integer deleteUserById(Integer id);

    Integer updateUserById(User user);

    Integer updateUserSwitchById(Integer id ,boolean isSwitch);
}
