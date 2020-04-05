package com.tech.uc.service.impl;

import com.tech.uc.entity.DictGroup;
import com.tech.uc.entity.DictItem;
import com.tech.uc.mapper.DictGroupMapper;
import com.tech.uc.mapper.DictItemMapper;
import com.tech.uc.service.DictItemService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements DictItemService {
    @Autowired
    private DictGroupMapper dictGroupMapper;

    @Autowired
    private DictItemMapper dictItemMapper;


    @Cacheable(cacheNames = "dict", keyGenerator = "keyGenerator")
    @Override
    public List<DictItem> getItemsByGroupKey(String groupKey) {
        return dictItemMapper.getItemsByGroupKey(groupKey);
    }

    @Override
    public List<DictItem> getItemsByGroupKeyAndPId(String groupKey, String pId) {
        return dictItemMapper.getItemsByGroupKeyAndPId(groupKey, pId);
    }

    @Cacheable(cacheNames = "dict", keyGenerator = "keyGenerator")
    @Override
    public List<DictItem> getItemsByGroupId(String groupId) {
        return dictItemMapper.getItemsByGroupId(groupId);
    }

    @Cacheable(cacheNames = "dict", keyGenerator = "keyGenerator")
    @Override
    public DictItem getUniqueItem(String groupKey, String itemKey) {
        return dictItemMapper.getUniqueItem(groupKey, itemKey);
    }

    @Override
    public DictItem getItemByGroupKeyAndValue(String groupKey, String value) {
        return dictItemMapper.getItemByGroupKeyAndValue(groupKey, value);
    }

    @Cacheable(cacheNames = "dict", keyGenerator = "keyGenerator")
    @Override
    public DictItem getDictItem(String itemId) {
        return dictItemMapper.selectById(itemId);
    }

    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(cacheNames = "dict", allEntries = true)
    @Override
    public void insertDictItem(DictItem dictItem) {
        dictItemMapper.insert(dictItem);
    }

    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(cacheNames = "dict", allEntries = true)
    @Override
    public void updateDictItem(DictItem target) {
        dictItemMapper.updateAllColumnById(target);
    }

    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(cacheNames = "dict", allEntries = true)
    @Override
    public void deleteDictItem(String id) {
        dictItemMapper.deleteById(id);
    }

    @Override
    public List<DictItem> findItemsByGroupKeys(List<String> keys) {
        return dictItemMapper.findItemsByGroupKeys(keys);
    }

    @Override
    public List<DictItem> findPItemsById(String id) {
        return dictItemMapper.findPItemsById(id);
    }


}
