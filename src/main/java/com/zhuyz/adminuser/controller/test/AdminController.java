package com.zhuyz.adminuser.controller.test;

import com.zhuyz.adminuser.entity.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuyz
 * @date 2020/4/3 0003 18:20
 * @description
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/video/order")
    public ResponseEntity findMyPlayRecord() {
        Map<String, String> recordMap = new HashMap<>();
        recordMap.put("Springboot入门到高级实战", "300元");
        recordMap.put("Cloud微服务入门到高级实战", "877元");
        recordMap.put("分布式缓存redis", "998元");
        return ResponseEntity.buildSuccess(recordMap);
    }

}
