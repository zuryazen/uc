package com.tech.uc.mapper;

import com.tech.uc.entity.DictItem;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
public interface DictItemMapper extends BaseMapper<DictItem> {

    List<DictItem> getItemsByGroupKey(String groupKey);

    DictItem getUniqueItem(@Param("groupKey") String groupKey, @Param("itemKey") String itemKey);

    List<DictItem> getItemsByGroupId(String groupId);


    DictItem getItemByGroupKeyAndValue(@Param("groupKey") String groupKey, @Param("value") String value);

    List<DictItem> getItemsByGroupKeyAndPId(@Param("groupKey") String groupKey, @Param("pId") String pId);

    List<DictItem> findItemsByGroupKeys(@Param("keys") List<String> keys);

    List<DictItem> findPItemsById(@Param("id") String id);
}
