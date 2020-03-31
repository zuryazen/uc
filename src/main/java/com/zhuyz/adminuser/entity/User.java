package com.zhuyz.adminuser.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class User {
    @NonNull
    private int id;
    private String name;
    private String password;
    private String address;
    private String email;
    // 是否启用
    private boolean isSwitch;

}
