package com.tech.uc.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageInfo;
import com.tech.uc.common.utils.RedisClient;
import com.tech.uc.common.utils.ResponseEntity;
import com.tech.uc.common.utils.UserContextUtil;
import com.tech.uc.entity.Resource;
import com.tech.uc.entity.User;
import com.tech.uc.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisClient redisClient;

    /**
     * 分页查询用户列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/findAll/{pageNum}/{pageSize}")
    public ResponseEntity<PageInfo<User>> findAllUser(@PathVariable("pageNum") Integer pageNum,
                                                      @PathVariable("pageSize") Integer pageSize, HttpServletRequest request) {
        PageInfo<User> userPageInfos = userService.findAllUserByPage(pageNum, pageSize);
        return ResponseEntity.buildSuccess(userPageInfos, "query ok");
    }

    @GetMapping("/findUser/{id}")
    public ResponseEntity findUserById(@PathVariable("id") Integer id) {
        ResponseEntity responseEntity = new ResponseEntity<>();
        User userById = userService.selectById(id);
        if (userById != null) {
            return ResponseEntity.buildSuccess(userById);
        } else {
            return ResponseEntity.buildCustom("user not found", 604);
        }
    }

    /**
     * 根据用户id删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteUserById(@PathVariable("id") Integer id) {
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        boolean state = userService.deleteById(id);
        if (state) {
            Integer pageTotal = userService.selectCount(new EntityWrapper<>());
            return ResponseEntity.buildSuccess(pageTotal, "delete ok");
        } else {
            return ResponseEntity.buildCustom(null, 601, "delete error");
        }
    }

    /**
     * 根据用户id更新是否启用开关
     * @param user
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<User> updateUserById(@RequestBody User user) {
        ResponseEntity<User> responseEntity = new ResponseEntity<>();
        boolean b = userService.updateById(user);
        return b ? ResponseEntity.buildSuccess(user, "update ok")
                : ResponseEntity.buildError(user, 602, "update error");
    }

    /**
     * 根据用户id更新用户
     * @param id
     * @param status
     * @return
     */
    @PutMapping("/updateStatus/{id}/{status}")
    public ResponseEntity<Integer> updateUserOpenById(@PathVariable("id") Integer id, @PathVariable("status") Integer status) {
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        User user = userService.selectById(id);
        user.setStatus(status);
        boolean b = userService.updateById(user);
        return b ? ResponseEntity.buildSuccess(1, "update ok")
                : ResponseEntity.buildError(-1, "update error");
    }


    /**
     * 获取当前用户所拥有的资源列表
     * @date 2018/12/07
     * @return
     */
    @PostMapping("/curMenus")
    public ResponseEntity getCurrentUserResourcesTree() {
        List<Resource> menus = UserContextUtil.currentMenus();
        return menus == null ?
                ResponseEntity.buildError("用户为空") : ResponseEntity.buildSuccess(menus);
    }


}

