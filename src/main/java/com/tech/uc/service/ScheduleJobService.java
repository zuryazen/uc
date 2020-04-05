package com.tech.uc.service;

import com.tech.uc.entity.ScheduleJob;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
public interface ScheduleJobService extends IService<ScheduleJob> {
    /**
     * 初始化任务
     */
    void initSchedule();

    /**
     * 更改状态
     * @param cmd start: 启动调度任务；stop: 停止调度任务
     */
    void changeStatus(String id, String cmd);

    /**
     * 更改任务cron表达式
     */
    void updateCron(String id);

    /**
     * 删除调度任务
     * @param id
     */
    void deleteById(String id);
}
