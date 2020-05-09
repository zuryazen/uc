package com.tech.uc.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.*;
import lombok.experimental.Accessors;

import static com.baomidou.mybatisplus.enums.IdType.UUID;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("T_BASE_USER")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID",type = UUID)
    private String id;

    // 用户名（登录名）
    @TableField("USERNAME")
    private String username;

    // 登录密码
    @TableField("PASSWORD")
    private String password;

    // 盐
    @TableField("SALT")
    private String salt;

    // 用户姓名
    @TableField("FULL_NAME")
    private String fullName;

    // 生日
    @TableField("BIRTHDAY")
    private Date birthday;

    // 性别（1：男；2：女；3：其他；4：保密）
    @TableField("SEX")
    private Integer sex;

    // 头像
    @TableField("ICON")
    private String icon;

    // 电子邮箱
    @TableField("EMAIL")
    private String email;

    // 联系电话
    @TableField("PHONE")
    private String phone;

    // 地址
    @TableField("ADDRESS")
    private String address;

    // 用户状态(0: 停用；1：启用)
    @TableField("STATUS")
    private Integer status;

    // 排序
    @TableField("SORT")
    private Double sort;

    // 备注
    @TableField("REMARKS")
    private String remarks;

    // 用户所属组织
    private List<Org> orgList;

    // 用户所属角色
    private List<Role> roleList;

    // 用户关联资源列表
    private List<Resource> resourceList;

    // 用户区属
    private String district;

    // 用户所属菜单（已被格式化为树形结构）
    private List<Resource> menus;

    // 用户附带的参数（扩展用）
    private Map<String, Object> params;

    // 存储token
    private String token;

    @TableField("CREATE_TIME")
    private Date createTime;
    @TableField("CREATE_USER_NAME")
    private String createUserName;
    @TableField("UPDATE_TIME")
    private Date updateTime;
    @TableField("UPDATE_USER_NAME")
    private String updateUserName;
    @TableField("DELETE_TIME")
    private Date deleteTime;
    @TableField("DELETE_USER_NAME")
    private String deleteUserName;
    @TableField("CREATE_USER")
    private String createUser;
    @TableField("UPDATE_USER")
    private String updateUser;
    @TableField("DELETE_USER")
    private String deleteUser;
    @TableField("DELETE_FLAG")
    private Integer deleteFlag;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
