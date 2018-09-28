package com.panda.english.core.response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.panda.english.core.util.DateUtils;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/4.
 */
public class BaseReturnEntity<T> implements Serializable {

    private int status;

    private T data;

    private String msg;

    private int timestamp;

    public BaseReturnEntity() {
    }

    public BaseReturnEntity(int status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
        this.timestamp = DateUtils.getIntUnixtime();
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(this);
    }
}
