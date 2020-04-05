package com.tech.uc.mapper;

import com.tech.uc.entity.Resource;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {

    /**
     * 根据角色ID获取该角色下资源列表
     * @param roleId
     * @return
     */
    List<Resource> findByRoleId(String roleId);


    List<Resource> findAll();

    void insertRoleResource(Resource resource);


}
