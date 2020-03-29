package com.zhuyz.admin_user.mapper;

import com.zhuyz.admin_user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface UserMapper {

    // 按照分页查询用户列表
    List<User> findAllUser();

    User findUserById(Integer id);

    // 用户列表总数
    Integer countAllUser();

    // 按照用户id删除指定用户
    Integer deleteUeserById(@RequestParam("id") Integer id);

    // 按照用户id更新指定用户
    Integer updateUesrById(User user);

}
