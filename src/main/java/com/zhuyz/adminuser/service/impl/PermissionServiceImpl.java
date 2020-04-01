package com.zhuyz.adminuser.service.impl;

import com.zhuyz.adminuser.entity.Permission;
import com.zhuyz.adminuser.mapper.PermissionMapper;
import com.zhuyz.adminuser.service.IPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-01
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
