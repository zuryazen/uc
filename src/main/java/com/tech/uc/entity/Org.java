package com.tech.uc.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 组织实体
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("T_BASE_ORG")
public class Org extends Model<Org> {

    private static final long serialVersionUID = 1L;

    private String id;

    // 父ID
    private String pid;

    // 组织全称
    private String fullName;

    // 组织简称
    private String simpleName;

    // 组织编码
    private String code;

    // 联系电话
    private String phone;

    // 成立日期
    private Date buildDate;

    // 排序
    private Double sort;

    // 备注
    private String remarks;

    // 层级 （非数据库字段，从通过树查询得出）
    private String level;

    // 组织层级
    private String orgLevel;

    // 组织区属
    private String district;



    private Date createTime;
    private String createUserName;
    private Date updateTime;
    private String updateUserName;
    private Date deleteTime;
    private String deleteUserName;
    private String createUser;
    private String updateUser;
    private String deleteUser;
    private Integer deleteFlag;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
