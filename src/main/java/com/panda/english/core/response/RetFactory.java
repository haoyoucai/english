package com.panda.english.core.response;

import org.apache.commons.lang3.StringUtils;

/**
 * 返回对象转化为JSON的封装
 * <p>
 * Copyright 2016-2017 tniu
 *
 * @author guoqp qpguo@51tniu.com
 * @version V1.0
 * @Title: RetFactory.java
 * @Package com.tniu.juexing.core.returninfo
 * @Description: 返回对象转化为JSON的封装
 * @date 2017年2月8日 下午6:38:54
 */
public class RetFactory {

    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final String UNAUTH = "unauthorized";
    private static final String DYNAMIC_NOT_FOUND_ERROR = "dynamic_not_found_error";
    private static final String COMMENT_NOT_FOUND_ERROR = "comment_not_found_error";

    private static final String SIGNERROR = "SIGNERROR";

    public static <T> BaseReturnEntity<T> getSuccess(T t, String msg) {
        return new BaseReturnEntity(Status.SUCCESS.getStatus(), t, StringUtils.isEmpty(msg) ? SUCCESS : msg);
    }

    public static <T> BaseReturnEntity<T> getSuccess(T t) {
        return new BaseReturnEntity(Status.SUCCESS.getStatus(), t, SUCCESS);
    }

    public static <T> BaseReturnEntity<T> getEntity(int status, T t, String msg) {
        return new BaseReturnEntity<>(status, t, StringUtils.isEmpty(msg) ? SUCCESS : msg);
    }

    public static <T> BaseReturnEntity<T> getError(T t, String msg) {
        return new BaseReturnEntity<>(Status.ERROR.getStatus(), t, StringUtils.isEmpty(msg) ? ERROR : msg);
    }

    public static <T> BaseReturnEntity<T> getError(String msg) {
        return new BaseReturnEntity<>(Status.ERROR.getStatus(), null, StringUtils.isEmpty(msg) ? ERROR : msg);
    }

    public static <T> BaseReturnEntity<T> get401() {
        return new BaseReturnEntity<>(Status.UNAUTH.getStatus(), null, UNAUTH);
    }

    public static <T> BaseReturnEntity<T> get301() {
        return new BaseReturnEntity<>(Status.CLIENTERROR.getStatus(), null, SIGNERROR);
    }

    public static <T> BaseReturnEntity<T> getDynamicNotFoundError(T t, String msg) {
        return new BaseReturnEntity<>(Status.DYNAMIC_NOT_FOUND_ERROR.getStatus(), t,
                StringUtils.isEmpty(msg) ? DYNAMIC_NOT_FOUND_ERROR : msg);
    }

    public static <T> BaseReturnEntity<T> getCommentNotFoundError(T t, String msg) {
        return new BaseReturnEntity<>(Status.COMMENT_NOT_FOUND_ERROR.getStatus(), t,
                StringUtils.isEmpty(msg) ? COMMENT_NOT_FOUND_ERROR : msg);
    }

    public static <T> BaseReturnEntity<T> getLoginSuccess(T t, String msg) {
        return new BaseReturnEntity<>(Status.SUCCESS.getStatus(), t, msg);
    }

    public static <T> BaseReturnEntity<T> getUnregistered(T t, String msg) {
        return new BaseReturnEntity<>(Status.ERROR.getStatus(), t, msg);
    }

    public static <T> BaseReturnEntity<T> getNoTaskReward(T t, String msg) {
        return new BaseReturnEntity<>(Status.NO_TASK_REWARD.getStatus(), t, msg);
    }

    public static <T> BaseReturnEntity<T> getPraiseSuccess(T t, String msg) {
        return new BaseReturnEntity<>(Status.SUCCESS.getStatus(), t, msg);
    }

    public static <T> BaseReturnEntity<T> getFastRegister(T t, String msg) {
        return new BaseReturnEntity<>(Status.FAST_REGISTER.getStatus(), t, msg);
    }

    public static <T> BaseReturnEntity<T> getNoBindTelephone(T t, String msg) {
        return new BaseReturnEntity<>(Status.NO_BIND_TELEPHONE.getStatus(), t, msg);
    }

    /**
     * 适用于没有返回数据的情况
     * data 为空
     *
     * @param statusCode
     * @param <T>
     * @return
     */
    public static <T> BaseReturnEntity<T> getResult(StatusCode statusCode) {
        return new BaseReturnEntity<>(statusCode.getStatus(), null, statusCode.getMsg());
    }

    /**
     * 适用于有返回数据的情况
     *
     * @param statusCode
     * @param <T>
     * @return
     */
    public static <T> BaseReturnEntity<T> getResult(StatusCode statusCode, T t) {
        return new BaseReturnEntity<>(statusCode.getStatus(), t, statusCode.getMsg());
    }

    /**
     * 适用于没有返回数据的情况
     * data 为空
     *
     * @param statusCode
     * @param <T>
     * @return
     */
    public static <T> BaseReturnEntity<T> getResult(StatusCode statusCode, String msg) {
        return new BaseReturnEntity<>(statusCode.getStatus(), null, msg);
    }
}
