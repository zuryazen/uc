package com.zhuyz.adminuser.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhuyz.adminuser.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    // 按照分页查询用户列表
    List<User> findAllUser();

    // 一个参数时可以舍去 @RequestParam("id")
    User findUserById(Integer id);

    @Select("select * from user where name = #{username}")
    User findUserByUsername(@Param("username") String username);

    // 用户列表总数
    Integer countAllUser();

    // 按照用户id删除指定用户
    Integer deleteUeserById(Integer id);

    // 按照用户id更新指定用户
    Integer updateUserById(User user);

    Integer updateUserOpenById(@Param("id") Integer id, @Param("open") boolean open);

}
