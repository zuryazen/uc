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
@TableName("T_BASE_FILE")
public class File extends Model<File> {

    private static final long serialVersionUID = 1L;

    private String id;

    // 文件名
    private String fileName;

    // 文件相对路径
    private String filePath;

    // 文件后缀
    private String fileSuffix;

    // 文件大小（KB）
    private Long fileSize;

    // 文件创建时间
    private Date fileCreateTime;

    // 文件更新时间
    private Date fileUpdateTime;

    // 文件是否可写，只针对文档格式， 0 可写， 1不可写（文档格式表示占用）
    private int editable;




    private String createUser;
    private String createUserName;
    private Date createTime;
    private String updateUser;
    private String updateUserName;
    private Date updateTime;
    private String deleteUser;
    private String deleteUserName;
    private Date deleteTime;
    private Integer deleteFlag;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
