package com.tech.uc.mapper;

import com.tech.uc.entity.Org;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
@Mapper
public interface OrgMapper extends BaseMapper<Org> {

    List<Org> getOrgListByPId(String pId);

    List<Org> getOrgListByCondition(Map<String, Object> params);

    List<Org> getOrgListByUserId(String userId);

    /**
     * 根据父组织ID获取组织树（包含自身）
     * @param pId
     * @return
     */
    List<Org> getAllOrgListByPId(String pId);


    List<Org> getAllOrgListById(String id);

    /**
     * 根据组织结构编码获取组织
     * @param code
     * @return
     */
    Org getByCode(String code);

    /**
     * 根据ID获取上级组织ID
     * @param id
     * @return
     */
    List<Org> getAllPOrgListById(String id);
}
