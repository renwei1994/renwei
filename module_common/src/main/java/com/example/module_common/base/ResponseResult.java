package com.example.module_common.base;

import com.example.module_common.exception.BaseException;
import com.example.module_common.exception.Status;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success = true;

    /**
     * 返回处理消息
     */
    private String message = "操作成功！";

    /**
     * 返回代码
     */
    private long code = 0;

    /**
     * 返回数据对象 data
     */
    private T data;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    public ResponseResult() {

    }

    protected ResponseResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseResult<T> error500(String message) {
        this.message = message;
        this.code = CommonConstant.SC_INTERNAL_SERVER_ERROR_500;
        this.success = false;
        return this;
    }

    public ResponseResult<T> success(String message) {
        this.message = message;
        this.code = CommonConstant.SC_OK_200;
        this.success = true;
        return this;
    }

    public static ResponseResult<Object> ok() {
        ResponseResult<Object> r = new ResponseResult<Object>();
        r.setSuccess(true);
        r.setCode(CommonConstant.SC_OK_200);
        r.setMessage("成功");
        return r;
    }

    public static ResponseResult<Object> ok(String msg) {
        ResponseResult<Object> r = new ResponseResult<Object>();
        r.setSuccess(true);
        r.setCode(CommonConstant.SC_OK_200);
        r.setMessage(msg);
        return r;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> ResponseResult<T> success(T data, String message) {
        return new ResponseResult<T>(Status.SUCCESS.getCode(), message, data);
    }

    public static ResponseResult<Object> ok(Object data) {
        ResponseResult<Object> r = new ResponseResult<Object>();

        return r;
    }

    public static ResponseResult<Object> error(String msg) {
        return error(CommonConstant.SC_INTERNAL_SERVER_ERROR_500, msg);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ResponseResult<T> unauthorized(T data) {
        return new ResponseResult<T>(Status.TOKEN_EXPIRED.getCode(), Status.TOKEN_EXPIRED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> ResponseResult<T> forbidden(T data) {
        return new ResponseResult<T>(Status.FORBIDDEN.getCode(), Status.FORBIDDEN.getMessage(), data);
    }

    public static ResponseResult<Object> error(int code, String msg) {
        ResponseResult<Object> r = new ResponseResult<Object>();
        r.setCode(code);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }

    /**
     * 构造一个有状态的API返回
     *
     * @param status 状态 {@link Status}
     * @return ApiResponse
     */
    public static ResponseResult ofStatus(Status status) {
        return ofStatus(status, null);
    }

    /**
     * 构造一个自定义的API返回
     *
     * @param code    状态码
     * @param message 返回内容
     * @param data    返回数据
     * @return ApiResponse
     */
    public static ResponseResult of(Integer code, String message, Object data) {
        return new ResponseResult(code, message, data);
    }
    /**
     * 构造一个成功且不带数据的API返回
     *
     * @return ApiResponse
     */
    public static ResponseResult ofSuccess() {
        return ofSuccess(null);
    }

    /**
     * 构造一个成功且带数据的API返回
     *
     * @param data 返回数据
     * @return ApiResponse
     */
    public static ResponseResult ofSuccess(Object data) {
        return ofStatus(Status.SUCCESS, data);
    }

    /**
     * 构造一个有状态且带数据的API返回
     *
     * @param status 状态 {@link Status}
     * @param data   返回数据
     * @return ApiResponse
     */
    public static ResponseResult ofStatus(Status status, Object data) {
        return of(status.getCode(), status.getMessage(), data);
    }

    /**
     * 构造一个异常的API返回
     *
     * @param t   异常
     * @param <T> {@link BaseException} 的子类
     * @return ApiResponse
     */
    public static <T extends BaseException> ResponseResult ofException(T t) {
        return of(t.getCode(), t.getMessage(), t.getData());
    }
    /**
     * 无权限访问返回结果
     */
    public static ResponseResult<Object> noauth(String msg) {
        return error(CommonConstant.SC_JEECG_NO_AUTHZ, msg);
    }
}
