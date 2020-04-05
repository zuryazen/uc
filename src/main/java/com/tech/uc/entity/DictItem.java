package com.tech.uc.entity;

import java.util.Date;
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
 * 字典项实体
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("T_BASE_DICT_ITEM")
public class DictItem extends Model<DictItem> {

    private static final long serialVersionUID = 1L;

    private String id;
    private String groupId;
    private String key;
    private String name;
    private String value;
    private String pid;
    private String description;
    private Integer sort;






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
