package com.zhuyz.adminuser.controller;

import com.github.pagehelper.PageInfo;
import com.zhuyz.adminuser.common.constant.Constant;
import com.zhuyz.adminuser.entity.ResponseEntity;
import com.zhuyz.adminuser.entity.User;
import com.zhuyz.adminuser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    // 分页查询用户列表
    @GetMapping("/findAll/{pageNum}/{pageSize}")
    public ResponseEntity<PageInfo<User>> findAllUser(@PathVariable("pageNum") Integer pageNum,
                                                @PathVariable("pageSize") Integer pageSize) {
        ResponseEntity<PageInfo<User>> responseEntity = new ResponseEntity<>();
        PageInfo<User> userPageInfos = userService.findAllUserByPage(pageNum, pageSize);
        responseEntity.setCode(Constant.StatusCode.OK);
        responseEntity.setMsg("query ok");
        responseEntity.setData(userPageInfos);
        return responseEntity;
    }

    @GetMapping("/findUser/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Integer id) {
        ResponseEntity<User> responseEntity = new ResponseEntity<>();
        User userById = userService.findUserById(id);
        if (userById != null) {
            responseEntity.setCode(Constant.StatusCode.OK);
            responseEntity.setMsg("query ok");
            responseEntity.setData(userById);
        } else {
            responseEntity.setCode(603);
            responseEntity.setMsg("user not found");
            responseEntity.setData(userById);
        }
        return responseEntity;
    }

    // 根据用户id删除用户
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteUserById(@PathVariable("id") Integer id) {
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        Integer state = userService.deleteUserById(id);
        if (state == 1) {
            Integer pageTotal = userService.countAllUser();
            responseEntity.setCode(Constant.StatusCode.OK);
            responseEntity.setMsg("delete ok");
            responseEntity.setData(pageTotal);
        } else {
            responseEntity.setCode(601); //code: 删除用户失败
            responseEntity.setMsg("delete error");
            responseEntity.setData(null);
        }
        return responseEntity;
    }

    // 根据用户id更新是否启用开关
    @PutMapping("/update")
    public ResponseEntity<User> updateUserById(@RequestBody User user) {
        ResponseEntity<User> responseEntity = new ResponseEntity<>();
        Integer state = userService.updateUserById(user);
        User userById = userService.findUserById(user.getId());
        if (state == 1) {
            responseEntity.setCode(Constant.StatusCode.OK);
            responseEntity.setMsg("update ok");
        } else {
            responseEntity.setCode(602); // 更新用户失败
            responseEntity.setMsg("update error");
        }
        responseEntity.setData(userById);
        return responseEntity;
    }


    // 根据用户id更新用户
    @PutMapping("/updateSwitch/{id}/{isSwitch}")
    public ResponseEntity<Integer> updateUserSwitchById(@PathVariable("id") Integer id, @PathVariable("isSwitch") boolean isSwitch) {
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        Integer state = userService.updateUserSwitchById(id, isSwitch);
        if (state == 1) {
            responseEntity.setCode(Constant.StatusCode.OK);
            responseEntity.setMsg("update switch ok");
        } else {
            responseEntity.setCode(603); // 更新switch失败
            responseEntity.setMsg("update switch error");
        }
        responseEntity.setData(state);
        return responseEntity;
    }

}
