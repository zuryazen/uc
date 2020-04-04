package com.zhuyz.adminuser.controller.test;

import com.zhuyz.adminuser.entity.ResponseEntity;
import com.zhuyz.adminuser.entity.User;
import com.zhuyz.adminuser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhuyz
 * @date 2020/4/2 0002 0:16
 * @description
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    private IUserService userService;


    @GetMapping("/find/{userId}")
    public Object findUserInfo(@PathVariable("userId") Integer userId) {
        User user = userService.findAllUserInfoByUserId(userId);
        return user;
    }


}
