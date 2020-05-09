package com.tech.uc.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageInfo;
import com.tech.uc.common.utils.JwtUtils;
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

import static com.tech.uc.common.constant.Constant.Auth.AUTHORIZATION;
import static com.tech.uc.common.constant.Constant.Auth.PREFIX_USER_INFO;
import static com.tech.uc.common.constant.Constant.StatusCode.*;

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
    public ResponseEntity<PageInfo<User>> findAllUser(
            @PathVariable("pageNum") Integer pageNum,
            @PathVariable("pageSize") Integer pageSize, HttpServletRequest request) {
        PageInfo<User> userPageInfos = userService.findAllUserByPage(pageNum, pageSize);
        return ResponseEntity.buildSuccess(userPageInfos);
    }

    @GetMapping("/findUser/{id}")
    public ResponseEntity findUserById(@PathVariable("id") Integer id) {
        User userById = userService.selectById(id);
        if (userById != null) {
            return ResponseEntity.buildSuccess(userById);
        } else {
            return ResponseEntity.buildCustom(USER_NOT_FOUND);
        }
    }

    /**
     * 根据用户id删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") Integer id) {
        boolean state = userService.deleteById(id);
        if (state) {
            Integer pageTotal = userService.selectCount(new EntityWrapper<>());
            return ResponseEntity.buildSuccess(pageTotal);
        } else {
            return ResponseEntity.buildCustom(DELETE_ERROR);
        }
    }

    /**
     * 根据用户id更新是否启用开关
     * @param user
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity updateUserById(@RequestBody User user) {
        boolean b = userService.updateById(user);
        return b ? ResponseEntity.buildSuccess(user)
                : ResponseEntity.buildCustom(user, UPDATE_ERROR);
    }

    /**
     * 根据用户id更新用户
     * @param id
     * @param status
     * @return
     */
    @PutMapping("/updateStatus/{id}/{status}")
    public ResponseEntity updateUserOpenById(@PathVariable("id") Integer id, @PathVariable("status") Integer status) {
        User user = userService.selectById(id);
        user.setStatus(status);
        return userService.updateById(user) ? ResponseEntity.buildSuccess() : ResponseEntity.buildCustom(UPDATE_ERROR);
    }


    /**
     * 获取当前用户所拥有的资源列表
     * @date 2018/12/07
     * @return
     */
    @PostMapping("/curMenus")
    public ResponseEntity getCurrentUserResourcesTree(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION);
        List<Resource> menus = userService.getMenus(token);
        return menus == null && menus.size() > 0 ?
                ResponseEntity.buildCustom("用户为空", NOT_FOUND) : ResponseEntity.buildSuccess(menus);
    }


}

