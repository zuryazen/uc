package com.tech.uc.common.utils;

import com.tech.uc.common.constant.Constant;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
        return new ResponseEntity<>(data, Constant.StatusCode.OK);
    }
    public static <T> ResponseEntity<T> buildSuccess(String msg) {
        return new ResponseEntity<>(null, Constant.StatusCode.OK, msg);
    }

    public static <T> ResponseEntity<T> buildSuccess(T data, String msg) {
        return new ResponseEntity<>(data, Constant.StatusCode.OK, msg);
    }

    public static <T> ResponseEntity<T> buildError(T data) {
        return new ResponseEntity<>(data, Constant.StatusCode.LOGIN_ERROR);
    }
    public static ResponseEntity buildError(String msg) {
        return new ResponseEntity<>(null, Constant.StatusCode.LOGIN_ERROR, msg);
    }

    public static <T> ResponseEntity<T> buildError(T data, String msg) {
        return new ResponseEntity<>(data, Constant.StatusCode.LOGIN_ERROR, msg);
    }
    public static <T> ResponseEntity<T> buildError(T data, int code, String msg) {
        return new ResponseEntity<>(data, code, msg);
    }

    public static <T> ResponseEntity<T> buildCustom(T data, int code) {
        return new ResponseEntity<>(data, code);
    }

    public static <T> ResponseEntity<T> buildCustom(T data, int code, String msg) {
        return new ResponseEntity<>(data, code, msg);
    }
}
