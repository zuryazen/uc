package com.zhuyz.adminuser.controller;

import com.zhuyz.adminuser.entity.ResponseEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuyz
 * @date 2020/4/3 0003 22:29
 * @description
 */
@RestController
public class LogoutController {


    // shiroConfig中配置了logout过滤器，这里可以不用配置
//    @GetMapping("/logout")
//    public ResponseEntity logout() {
//        SecurityUtils.getSubject().logout();
//        return ResponseEntity.buildSuccess("退出登录成功");
//    }

}
