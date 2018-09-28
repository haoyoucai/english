package com.panda.english.core.response;

/**
 * 返回状态
 * <p>
 * Copyright 2016-2017 tniu
 *
 * @author guoqp qpguo@51tniu.com
 * @version V1.0
 * @Title: Status.java
 * @Package com.tniu.juexing.core.returninfo
 * @Description: 返回状态
 * @date 2017年2月8日 下午6:39:25
 */
public enum Status {
    SUCCESS(0), ERROR(1), UNAUTH(401),
    DYNAMIC_NOT_FOUND_ERROR(2), COMMENT_NOT_FOUND_ERROR(3),
    /* 直播间不存在 */
    LIVE_ROOM_NOT_FIND(4),
    /* 直播已关闭 */
    LIVE_ROOM_FINISHED(5),
    CLIENTERROR(301), NO_TASK_REWARD(601), FAST_REGISTER(302), NO_BIND_TELEPHONE(402);
    private int status;

    Status(int i) {
        this.status = i;
    }

    public int getStatus() {
        return status;
    }
}

