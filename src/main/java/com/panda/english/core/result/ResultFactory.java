package com.panda.english.core.result;


import com.panda.english.core.response.StatusCode;

/**
 * Copyright 2016-2017 tniu
 *
 * @author 吕洪涛 htlv@51tniu.com
 * @date 2018/02/28
 * @description 包装统一的返回信息
 */
public class ResultFactory {

    public static <T> ResultEntity<T> getSuccess(T t, String msg) {
        return new ResultEntity(ResultStatus.SUCCESS.getStatus(), t, msg);
    }

    public static <T> ResultEntity<T> getSuccess(String msg) {
        return new ResultEntity(ResultStatus.SUCCESS.getStatus(), msg);
    }

    public static <T> ResultEntity<T> getSuccess() {
        return new ResultEntity(ResultStatus.SUCCESS.getStatus(), ResultStatus.SUCCESS.getMessage());
    }

    public static <T> ResultEntity<T> getError(String msg) {
        return new ResultEntity(ResultStatus.ERROR.getStatus(), msg);
    }

    public static <T> ResultEntity<T> getError() {
        return new ResultEntity(ResultStatus.ERROR.getStatus(), ResultStatus.ERROR.getMessage());
    }

    public static <T> ResultEntity<T> getStatus() {
        return new ResultEntity(ResultStatus.ERROR.getStatus(), ResultStatus.ERROR.getMessage());
    }

    /**
     * 适用于没有返回数据的情况
     * data 为空
     *
     * @param statusCode
     * @param <T>
     * @return
     */
    public static <T> ResultEntity<T> getResult(StatusCode statusCode) {
        return new ResultEntity<>(statusCode.getStatus(), null, statusCode.getMsg());
    }

    /**
     * 适用于有返回数据的情况
     *
     * @param statusCode
     * @param <T>
     * @return
     */
    public static <T> ResultEntity<T> getResult(StatusCode statusCode, T t) {
        return new ResultEntity<>(statusCode.getStatus(), t, statusCode.getMsg());
    }

    /**
     * 适用于没有返回数据的情况
     * data 为空
     *
     * @param statusCode
     * @param <T>
     * @return
     */
    public static <T> ResultEntity<T> getResult(StatusCode statusCode, String msg) {
        return new ResultEntity<>(statusCode.getStatus(), null, msg);
    }
}
