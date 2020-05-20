package com.tech.uc.vo;

import com.tech.uc.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhuyz
 * @date 2020/5/20 0020 21:06
 * @description
 */
@Data
@NoArgsConstructor
public class UserIdRolesVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private List<Role> roleList;



}
