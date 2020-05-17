package com.tech.uc.controller;


import com.tech.uc.common.utils.ResponseEntity;
import com.tech.uc.entity.Resource;
import com.tech.uc.service.ResourceService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;


    @RequiresRoles(value = {"101", "100", "000"}, logical = Logical.OR)
    @GetMapping("/findAllResource")
    public ResponseEntity getAllResource(HttpServletRequest request) {
        return ResponseEntity.buildSuccess(resourceService.findAll());
    }




}

