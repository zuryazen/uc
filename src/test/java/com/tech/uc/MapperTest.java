package com.tech.uc;

import com.tech.uc.entity.User;
import com.tech.uc.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author zhuyz
 * @date 2020/4/24 0024 22:34
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testfindAllUser() {

        List<User> allUser = userMapper.findAllUser();

    }

    @Test
    public void testfindUserByUsername() {

       User user = userMapper.findByUsername("root");

    }


}
