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
 * 
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("T_BASE_SERVER")
public class Server extends Model<Server> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    // 服务器名称
    @TableField("SERVER_NAME")
    private String serverName;

    // 请求uri(http://ip:port/contextPath)
    @TableField("URI")
    private String uri;

    // 项目编号
    @TableField("PROJECT_NO")
    private String projectNo;

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
