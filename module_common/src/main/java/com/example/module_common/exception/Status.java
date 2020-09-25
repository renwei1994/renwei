package com.example.module_common.exception;

import lombok.Getter;

@Getter
public enum Status {
    SUCCESS(0, "操作成功"),
    FAILED(500, "操作失败"),

    FORBIDDEN(403, "没有相关权限"),

    //登录验证
    TOKEN_EXPIRED(401, "登录已过期，请重新登录");


    private int code;
    private String message;

    Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
