package com.tech.uc.service;

import com.tech.uc.entity.DictGroup;
import com.tech.uc.entity.DictItem;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
public interface DictItemService extends IService<DictItem> {

    /**
     * 根据字典组key获取字典项列表
     * @param groupKey
     * @return
     */
    List<DictItem> getItemsByGroupKey(String groupKey);

    /**
     * 根据字典组key和pId获取字典项列表
     * @param groupKey
     * @param pId
     * @return
     */
    List<DictItem> getItemsByGroupKeyAndPId(String groupKey, String pId);

    /**
     * 根据字典组id获取字典项列表
     * @param groupId
     * @return
     */
    List<DictItem> getItemsByGroupId(String groupId);

    /**
     * 根据字典组key和字典项key获取字典项
     * @param groupKey
     * @param itemKey
     * @return
     */
    DictItem getUniqueItem(String groupKey, String itemKey);

    /**
     * 根据字典组key和字典项值获取字典项
     * @param groupKey
     * @param value
     * @return
     */
    DictItem getItemByGroupKeyAndValue(String groupKey, String value);

    /**
     * 插入字典项
     * @param dictItem
     */
    void insertDictItem(DictItem dictItem);

    /**
     * 根据字典项id获取字典项
     * @param itemId
     * @return
     */
    DictItem getDictItem(String itemId);

    /**
     * 更新字典项
     * @param target
     */
    void updateDictItem(DictItem target);

    /**
     * 删除字典项
     * @param id
     */
    void deleteDictItem(String id);

    List<DictItem> findItemsByGroupKeys(List<String> keys);

    List<DictItem> findPItemsById(String id);
}
