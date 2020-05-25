package com.tech.uc.controller;


import com.tech.uc.common.utils.ResponseEntity;
import com.tech.uc.entity.User;
import com.tech.uc.service.UserService;
import com.tech.uc.vo.UserVO;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private UserService userService;

    @PostMapping("/uploadUser")
    public ResponseEntity importUser(@RequestBody Map<String, List<UserVO>> map, HttpServletRequest request) {
        List<UserVO> userExcelList = map.get("dataList");
        List<User> newUsers = new ArrayList<>();
        userExcelList.forEach(userVO -> newUsers.add(new User(userVO.getUsername(), userVO.getPassword())));
        userService.addUsers(newUsers);
        return ResponseEntity.buildSuccess();
    }




}

