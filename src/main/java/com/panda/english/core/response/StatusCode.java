package com.panda.english.core.response;

/**
 * Copyright 2016-2017 tniu
 *
 * @author 吕洪涛 htlv@51tniu.com
 * @date 2017/05/27
 * @description 所有接口的状态码定义
 */
public enum StatusCode {

    SUCCESS(0),
    ERROR(1),
    NO_DATA(900,"暂无数据"),

    SIGN_ERROR(301, "验签失败"),
    TOKEN_ERROR(401, "登录过期"),
    REPEAT_REQUEST(1004, "请勿重复请求"),

    PARAMS_IS_NULL(1001, "缺少必要参数"),
    PARAMS_IS_WRONG(1002, "参数错误"),
    VERSION_IS_BIG(1003, "客户端版本号大于指定版本号"),
    STOCK_BANKER_BAN_DATE_HOLD(3001, "当前时间不可举牌"),
    STOCK_BANKER_BAN_USER_HOLD(3002, "用户不可举牌"),
    STOCK_BANKER_PLACARDS(3004, "该股票已被举牌"),
    STOCK_BANKER_USER_IS_BAN(3010, "用户被禁止举牌"),
    STOCK_BANKER_LOCK(3006, "该股票被人工锁定，不可继续竞猜"),
    STOCK_BANKER_INSPECT_LV(3007, "用户等级不足"),
    STOCK_BANKER_LIMIT(3008, "您举牌已超过%d次"),
    STOCK_ZDL_BAN_DATE_HOLD(3101, "当前时间不可竞猜"),
    STOCK_ZDL_NOT_FOUND(3102, "竞猜局不存在"),
    STOCK_ZDL_FINISHED(3103, "竞猜局已关闭"),
    STOCK_ZDL_NOT_IN_PLAYINT(3043, "您参与的游戏不在竞猜状态"),
    STOCK_ZDL_FORWARD_WRONG(3044, "竞猜方向只能为涨、跌、平"),



    TZERO_DIAMOND_NOT_TRADING_TIME(3102, "当前已收盘，不在游戏时间段内"),
    TZERO_NOT_ENOUGH_TIME(3103, "游戏时间不足"),
    TZERO_DIAMOND_NOT_ENOUGH(3104, "您的账户余额不足，无法参与游戏"),
    TF_NOT_ADD_NEXT_GAME(3105, "您不能才加下一局"),
    TF_NOT_AT_OPEN_TIME(3106,"当前时间不在开盘时间段内"),
    TF_MEMBER_NOT_AT_GAME(3107,"用户不在当前游戏内"),
    TF_MEMBER_NOT_IDENTITY(3108,"用户身份不对"),
    TF_NO_WATCH_UID(3109,"当前游戏没有可观战的玩家"),
    TF_NOT_NEXT_GAME(3111,"已经没有下一局啦"),
    TF_MEMBER_IN_GAME(3112,"该用户已经在游戏中，是否要重新连接"),
    TF_ROOM_NO(3113,"该房间不存在"),
    TF_ROOM_NO_PASSWORD(3114,"房间密码不准确"),
    TF_ROOM_NO_WATCH(3115,"房间不允许观战"),
    TF_ROOM_PLAYING(3116,"房间已经开始游戏"),
    TF_UPDATE_ENTER_NEXT_GAME(3117,"离游戏结束时间少于15秒，不能点击参加下一局"),
    TF_THIRD_NOT_ENTER_GAME(3118,"游戏已经结束或者不允许观战"),


    CURRENCY_TICKET_NOT_ENOUGH(4001, "您的牛票余额不足"),
    CURRENCY_DIAMOND_NOT_ENOUGH(4002, "您的牛钻余额不足"),
    CURRENCY_GOLD_NOT_ENOUGH(4003, "您的牛票余额不足"),
    CURRENCY_CAN_NOT_BEZERO(4004, "下注金额要不能为0"),

    USER_NOT_FOUND(5001, "没有查询到该用户"),
    USER_NOT_BIND_PHONE(5002, "您还没有绑定手机号哦"),
    USER_BAN_TALK(5003, "您已被禁言"),
    FOLLOWED_USER(5004, "您已关注该用户"),
    UN_FOLLOW_USER(5005, "您还未关注该用户"),
    USER_BAN_ACCOUNT(5004, "您已被封号"),
    USER_NEED_LOGIN(401, "登录失效"),

    NOT_TRADING_TIME(6001, "非交易时间"),
    FUND_NOT_ENOUGH(6002, "资金不足"),
    GAME_HAS_NOT_SETTLE(6003,"游戏还没结算完"),

    STOCK_ZDL_NOT_FIND(7001, "没有进行中的竞猜"),
    BRANCH_STOCK_OUT_OF_RANK(7000,"该只股票没有上龙虎榜"),

    PUB_FALSH_COUNT_LIMIT(7002,"发布闪讯次数超过限制"),
    REWARD_FLASH_TIME_LIMIT(7003,"闪讯即将销毁，不能打赏哦！"),
    REWARD_FLASH(7004,"打赏成功，您打赏的闪讯已被收进\"我的收藏\"，可随时查阅"),

    SIMULATION_GAME_INVITECODE_WRONG(8000,"邀请码错误"),
    SIMULATION_GAME_IDENTIFYCODE_WRONG(8001,"验证码错误"),
    SIMULATION_GAME_REPORTED(8002,"你已经报名"),
    SIMULATION_GAME_CLEARAMOUNT(8003,"清零操作"),
    SIMULATION_GAME_USER_NOT_REGIST(8004,"该手机尚未注册，请下载天牛金娱APP并注册账号。"),
    SIMULATION_GAME_USER_NOT_REPORT(8005,"你还未报名,请先报名!");

    private int code;
    private String msg;

    StatusCode(int code) {
        this(code, null);
    }

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getStatus() {
        return code;
    }

    public void setStatus(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }
}
