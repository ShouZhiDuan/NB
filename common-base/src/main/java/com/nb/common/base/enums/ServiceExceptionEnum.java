package com.nb.common.base.enums;

/**
 * @author dev
 */
public enum ServiceExceptionEnum {

    /**
     * 系统级别
     */
    SUCCESS(0, "成功"),

    /**
     * 系统异常
     * prefix=10
     */
    METHOD_ARGUMENT_NOT_VALID_EXCEPTION(100000, "METHOD_ARGUMENT_NOT_VALID_EXCEPTION"),
    BIND_EXCEPTION(100001, "METHOD_ARGUMENT_NOT_VALID_EXCEPTION"),
    CONSTRAINT_VIOLATION_EXCEPTION(100002, "METHOD_ARGUMENT_NOT_VALID_EXCEPTION"),
    MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION(100003, "METHOD_ARGUMENT_NOT_VALID_EXCEPTION"),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION(100004, "METHOD_ARGUMENT_NOT_VALID_EXCEPTION"),

    /**
     * 用户模块
     * prefix=20
     */
    USER_NOT_FOUND(200000, "用户不存在")

    ;

    /**
     * 错误码
     */
    private final int code;
    /**
     * 错误提示
     */
    private final String message;

    ServiceExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ServiceExceptionEnum{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
