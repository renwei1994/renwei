package com.example.module_common.exception;

import lombok.Data;

@Data
public class BaseException extends RuntimeException {
    private Integer code;
    private String message;
    private Object data;

    BaseException(Status status) {
        this.message = status.getMessage();
        this.code = status.getCode();
    }

    public BaseException(Status status, Object data) {
        this(status);
        this.data = data;
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseException(Integer code, String message, Object data) {
        this(code, message);
        this.data = data;
    }

}
