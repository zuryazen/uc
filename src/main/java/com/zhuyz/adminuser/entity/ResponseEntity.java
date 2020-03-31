package com.zhuyz.adminuser.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseEntity<T> {
    // 状态码
    private int code;
    private String msg;
    private T data;

}
