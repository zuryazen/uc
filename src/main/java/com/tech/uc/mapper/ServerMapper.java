package com.tech.uc.mapper;

import com.tech.uc.entity.Server;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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
public interface ServerMapper extends BaseMapper<Server> {

    String getServerNameByUri(String uri);

    List<Server> getServerListByUri(String uri);
}
