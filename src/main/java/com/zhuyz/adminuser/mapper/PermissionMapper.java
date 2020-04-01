package com.zhuyz.adminuser.mapper;

import com.zhuyz.adminuser.entity.Permission;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-01
 */
public interface PermissionMapper extends BaseMapper<Permission> {


    @Select("select p.id as id, p.name as name, p.url as url from role_permission rp left join permission p on rp.permission_id = p.id "
            + "where rp.role_id = #{roleId}")
    List<Permission> findPermissionListByRoleId(@Param("roleId") Integer roleId);


}
