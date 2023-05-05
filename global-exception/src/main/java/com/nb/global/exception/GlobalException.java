package com.nb.global.exception;

public class GlobalException extends RuntimeException{
    private Integer code;
    private String msg;

    public GlobalException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public GlobalException(String message) {
        super(message);
        this.msg = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "GlobalException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
