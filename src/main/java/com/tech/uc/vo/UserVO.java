package com.tech.uc.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhuyz
 * @date 2020/4/2 0002 23:53
 * @description user value object
 */
@Data
@NoArgsConstructor
public class UserVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private Date birthdate;
    private String email;
    private Integer sex;
    private String phone;


}
