package com.tech.uc.common.utils;

import com.tech.uc.common.constant.Constant;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static com.tech.uc.common.constant.Constant.StatusCode.LOGIN_ERROR;
import static com.tech.uc.common.constant.Constant.StatusCode.OK;

@Data
@NoArgsConstructor
public class ResponseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;


    // 状态码
    private int code;
    private String msg;
    private T data;

    public ResponseEntity(T data, int code) {
        this.data = data;
        this.code = code;
    }
    public ResponseEntity(T data, int code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public static <T> ResponseEntity<T> buildSuccess(T data) {
        return new ResponseEntity<>(data, OK);
    }
    public static <T> ResponseEntity<T> buildSuccess(String msg) {
        return new ResponseEntity<>(null, OK, msg);
    }

    public static <T> ResponseEntity<T> buildSuccess(T data, String msg) {
        return new ResponseEntity<>(data, OK, msg);
    }

    public static ResponseEntity loginError(String msg) {
        return new ResponseEntity<>(null, LOGIN_ERROR, msg);
    }

    public static <T> ResponseEntity<T> loginError(T data, String msg) {
        return new ResponseEntity<>(data, LOGIN_ERROR, msg);
    }

    public static <T> ResponseEntity<T> loginError(T data) {
        return new ResponseEntity<>(data, LOGIN_ERROR);
    }

    public static <T> ResponseEntity<T> buildCustom(T data, int code) {
        return new ResponseEntity<>(data, code);
    }

    public static <T> ResponseEntity<T> buildCustom(T data, int code, String msg) {
        return new ResponseEntity<>(data, code, msg);
    }
}
