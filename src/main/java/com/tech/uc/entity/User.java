package com.tech.uc.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
@TableName("T_BASE_USER")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    private String id;

    // 用户名（登录名）
    private String username;

    // 登录密码
    private String password;

    // 盐
    private String salt;

    // 用户姓名
    private String fullName;

    // 生日
    private Date birthday;

    // 性别（1：男；2：女；3：其他；4：保密）
    private Integer sex;

    // 头像
    private String icon;

    // 电子邮箱
    private String email;

    // 联系电话
    private String phone;

    // 地址
    private String address;

    // 用户状态(0: 停用；1：启用)
    private Integer status;

    // 排序
    private Double sort;

    // 备注
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
    private List<Map<String, Object>> menus;

    // 用户附带的参数（扩展用）
    private Map<String, Object> params;

    private String token;






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
