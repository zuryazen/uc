package com.tech.uc.mapper;

import com.tech.uc.entity.File;
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
public interface FileMapper extends BaseMapper<File> {

    List<File> getFileList(List<String> ids);
}
