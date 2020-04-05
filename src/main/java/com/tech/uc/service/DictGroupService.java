package com.tech.uc.service;

import com.baomidou.mybatisplus.service.IService;
import com.tech.uc.entity.DictGroup;
import com.tech.uc.entity.DictItem;

import java.util.List;

/**
 * @author zhuyz
 * @date 2020/4/5 0005 17:38
 * @description
 */
public interface DictGroupService extends IService<DictGroup> {

    /**
     * 获取所有的字典组
     * @return
     */
    List<DictGroup> getAll();
}
