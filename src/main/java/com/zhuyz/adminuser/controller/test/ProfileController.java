package com.zhuyz.adminuser.controller.test;

import com.sun.org.apache.bcel.internal.generic.RET;
import com.zhuyz.adminuser.entity.ResponseEntity;
import com.zhuyz.adminuser.entity.User;
import com.zhuyz.adminuser.entity.UserRole;
import com.zhuyz.adminuser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuyz
 * @date 2020/4/3 0003 0:10
 * @description profile controller
 */
@RestController
@RequestMapping("/authc")
public class ProfileController {

    @Autowired
    private IUserService userService;

    @GetMapping("/lookProfile/{id}")
    public ResponseEntity findUserProfile(@PathVariable("id") Integer id) {
        User user = userService.findUserById(id);
        System.out.println("sdfdsf");
        return user != null ? ResponseEntity.buildSuccess(user) : ResponseEntity.buildError("用户不存在或者已经被禁用");
    }




}
