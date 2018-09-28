package com.panda.english.core.result;

/**
 * Copyright 2016-2017 tniu
 *
 * @author 吕洪涛 htlv@51tniu.com
 * @date 2018/02/28
 * @description 状态码
 */
public enum ResultStatus {

    /**
     * 成功
     */
    SUCCESS(0, "success"),

    /**
     * 失败
     */
    ERROR(1, "error");

    private int status;

    private String message;

    ResultStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
