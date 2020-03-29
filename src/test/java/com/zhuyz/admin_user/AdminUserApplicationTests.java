package com.zhuyz.admin_user;

import com.zhuyz.admin_user.entity.User;
import com.zhuyz.admin_user.mapper.UserMapper;
import com.zhuyz.admin_user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminUserApplicationTests {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
    }


    @Test
    public void testCount() {

        System.out.println(userMapper.countAllUser());

    }


    @Test
    public void testUpdate() {
        User user = new User();
        user.setName("wahaha");
        user.setId(22);
        user.setPassword("1231232132132");
        user.setAddress("US");
        user.setEmail("sdfdsfds@qq.com");
        System.out.println(userService.updateUesrById(user));

    }
}
