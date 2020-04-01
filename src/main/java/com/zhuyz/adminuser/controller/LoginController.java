package com.zhuyz.adminuser.controller;

import com.zhuyz.adminuser.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhuyz
 * @date 2020/4/1 0001 21:16
 * @description
 */
@RestController
public class LoginController {


    @PostMapping("/login")
    public String login(@RequestBody User user) {





        return null;
    }




}
