package com.zhuyz.adminuser.mapper;

import com.zhuyz.adminuser.entity.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-01
 */
public interface RoleMapper extends BaseMapper<Role> {


    @Select("select ur.role_id as id, r.name as name, r.description as description "
            + "from user_role ur left join role r on ur.role_id = r.id "
            + "where ur.user_id = #{userId}")
    @Results(
            value = {
                    @Result(id = true, property = "id", column = "id"),
                    @Result(property = "name", column = "name"),
                    @Result(property = "description", column = "description"),
                    @Result(property = "permissionList", column = "id",
                        many = @Many(select = "com.zhuyz.adminuser.mapper.PermissionMapper.findPermissionListByRoleId",
                                fetchType = FetchType.DEFAULT)
                    )
            }
    )
    List<Role> findRoleListByUserId(@Param("userId") Integer userId);


}
