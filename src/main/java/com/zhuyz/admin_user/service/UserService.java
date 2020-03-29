package com.zhuyz.admin_user.service;

import com.github.pagehelper.PageInfo;
import com.zhuyz.admin_user.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();

    PageInfo<User> findAllUserByPage(int pageNum, int pageSize);

    User findUserById(Integer id);

    Integer countAllUser();

    Integer deleteUserById(Integer id);

    Integer updateUesrById(User user);

}
