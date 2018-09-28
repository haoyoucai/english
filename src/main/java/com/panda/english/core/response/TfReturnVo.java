package com.panda.english.core.response;


import com.panda.english.core.util.DateUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 股指期货返回类型
 * Copyright 2016-2017 tniu
 *
 * @author zjf
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2017/8/30 10:55
 */
public class TfReturnVo<T> implements Serializable {

    private static final String SUCCESS = "success";

    private static final String ERROR = "error";


    private T t;

    private String msg;

    private String operCode;

    private int status;

    private int timestamp;


    public TfReturnVo() {
    }

    public TfReturnVo(String operCode, T t, String msg,  int status) {
        this.msg = msg;
        this.operCode = operCode;
        this.status = status;
        this.timestamp = DateUtils.getIntUnixtime();
        this.t=t;

    }

    public static <T> TfReturnVo<T> getSuccess(String code, T t, String msg) {
        return new TfReturnVo<>(code, t, StringUtils.isEmpty(msg) ? SUCCESS : msg, Status.SUCCESS.getStatus());
    }


    public static <T> TfReturnVo<T> getError(String code, T t, String msg) {
        return new TfReturnVo<>(code, t, StringUtils.isEmpty(msg) ? ERROR : msg,  Status.ERROR.getStatus());
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



    public String getOperCode() {
        return operCode;
    }

    public void setOperCode(String operCode) {
        this.operCode = operCode;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }




}
