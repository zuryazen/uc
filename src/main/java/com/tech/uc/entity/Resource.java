package com.tech.uc.entity;

import java.util.ArrayList;
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
 * 资源实体
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("T_BASE_RESOURCE")
public class Resource extends Model<Resource> {

    private static final long serialVersionUID = 1L;

    private String id;

    // 资源名称
    private String name;

    // 父级资源ID
    private String pid;

    // 资源类型（1：菜单；2：操作）
    private String type;

    // 资源URI
    private String uri;

    // shiro 权限字符串
    private String permission;

    //是否启用(0：不启用，1：启用)
    private Integer enabled;

    // 排序
    private Double sort;

    // 备注
    private String remarks;

    // 项目编号
    private String projectNo;

    // 图标名称
    private String icon;

    // 组件名称-用于 前台侧边栏 路由index赋值
    private String componentName;


    // 子菜单集合
    private List<Resource> childrens = new ArrayList<>();











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
