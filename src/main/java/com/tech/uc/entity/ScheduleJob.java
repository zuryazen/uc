package com.tech.uc.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("T_BASE_SCHEDULE_JOB")
public class ScheduleJob extends Model<ScheduleJob> {

    private static final long serialVersionUID = 1L;

    private String id;

    // 任务名称
    private String jobName;

    // 任务分组
    private String jobGroup;

    // 任务状态
    private String jobStatus;

    // 并发状态
    private String isConcurrent;

    // cron表达式
    private String cronExpression;

    // 需要执行任务的包名 + 类名
    private String beanClass;

    // 方法名
    private String methodName;

    // 需要执行任务的bean名称（与beanClass 互斥，只要配置一个，优先springBean）
    private String springBean;

    // 任务描述
    private String description;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
