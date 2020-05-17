package com.tech.uc.controller;


import com.tech.uc.common.utils.ResponseEntity;
import com.tech.uc.service.RoleService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequiresRoles(value = {"101", "100", "000"}, logical = Logical.OR)
    @GetMapping("/findAllRole/{pageNum}/{pageSize}")
    public ResponseEntity findAllRole(
            @PathVariable("pageNum") Integer pageNum,
            @PathVariable("pageSize") Integer pageSize, HttpServletRequest request) {
        return ResponseEntity.buildSuccess(roleService.findAllRoleByPage(pageNum, pageSize));
    }



    @PutMapping("/addResourcesByRoleId/{roleId}")
    public ResponseEntity addResourcesByRoleId(@PathVariable("roleId") String roleId,
                                               @RequestBody List<String> resourceIds) {
        roleService.saveRoleResources(roleId, resourceIds);
        return ResponseEntity.buildSuccess();
    }

    @PutMapping("addUsersByRoleId/{roleId}")
    public ResponseEntity addUsersByRoleId(@PathVariable("roleId") String roleId, @RequestBody List<String> userIds) {
        roleService.saveRoleUsers(roleId, userIds);
        return ResponseEntity.buildSuccess();
    }







}

