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
 * 字典组实体
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("T_BASE_DICT_GROUP")
public class DictGroup extends Model<DictGroup> {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String key;
    private Integer sort;
    private String description;




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
