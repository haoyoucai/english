package com.panda.english.core.result;

import java.io.Serializable;

/**
 * Copyright 2016-2017 tniu
 *
 * @author 吕洪涛 htlv@51tniu.com
 * @date 2018/02/28
 * @description 接口层返回给页面层的统一包装类
 */
public class ResultEntity<T> implements Serializable {

    /**
     * 0 成功
     */
    private int status;

    /**
     * 额外的数据
     */
    private T data;

    /**
     * 提示信息
     */
    private String message;

    public ResultEntity() {
    }

    public ResultEntity(int status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public ResultEntity(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
