package com.tech.uc.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 *  角色实体
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("T_BASE_ROLE")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;


    private String id;

    // 角色名称
    private String name;

    // 角色编码
    private String code;

    // 是否启用 (0: 否；1：是)
    private Integer enabled;

    // 角色所属组织
    private String orgId;

    // 排序
    private Double sort;

    // 备注
    private String remarks;

    // 角色对应用户集合
    private List<User> userList;

    // 角色对应资源集合
    private List<Resource> resourceList;


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
