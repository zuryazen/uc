package com.tech.uc.service.impl;

import com.tech.uc.entity.ScheduleJob;
import com.tech.uc.mapper.ScheduleJobMapper;
import com.tech.uc.service.ScheduleJobService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class ScheduleJobServiceImpl extends ServiceImpl<ScheduleJobMapper, ScheduleJob> implements ScheduleJobService {

    @Override
    public void initSchedule() {

    }

    @Override
    public void changeStatus(String id, String cmd) {

    }

    @Override
    public void updateCron(String id) {

    }

    @Override
    public void deleteById(String id) {

    }
}
