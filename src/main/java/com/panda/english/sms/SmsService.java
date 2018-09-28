package com.panda.english.sms;

import com.google.gson.Gson;
import com.panda.english.core.response.BaseReturnEntity;
import com.panda.english.core.response.RetFactory;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class SmsService {

    private static final Logger logger = LoggerFactory.getLogger(SmsService.class);

//    @Autowired
//    private CommonRedis commonRedis;
//    @Autowired
//    private TnRedisService tnRedisService;

    public static final String APP_ID = "1400012240";
    public static final String APP_KEY = "57730a68bea8786f7c5d33c8307f85a8";

//    @Value("#{applicationProperties['IM_ISTEST']}")
    private boolean isTest;
//
//    public CommonRedis getCommonRedis() {
//        return commonRedis;
//    }
//
//    public void setCommonRedis(CommonRedis commonRedis) {
//        this.commonRedis = commonRedis;
//    }

    private static final Gson gson = new Gson();

    /**
     * 微信提现获取手机验证码
     *
     * @param phone 手机号
     * @return BaseReturnEntity
     */
    public BaseReturnEntity<String> sendSmsWxDraw(String phone) {
//        String s = tnRedisService.getKeyShard(RedisDataShardEnum.default_zero, phone + "sendSmsWxDraw");
//        if (!StringUtils.isEmpty(s) && Integer.valueOf(s) >= 10) {
//            return RetFactory.getError("top", "今天获取验证码已达上限");
//        }
//        if (StringUtils.isEmpty(s)) {
//            s = "0";
//        }
        try {
            //获取当前时间是几点
            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            //添加同一手机号获取验证码计数器
//            tnRedisService.setTnRedisShard(RedisDataShardEnum.default_zero, phone + "sendSmsWxDraw", String.valueOf(Integer.valueOf(s) + 1), 24 - hour, TimeUnit.HOURS);
        } catch (NumberFormatException e) {
            logger.error("数据转换异常", e);
        }
        return this.sendSms(phone);
    }


    /**
     * 发送短消息验证码
     *
     * @param phone
     * @return
     */
    public BaseReturnEntity<String> sendSms(String phone) {
        //TODO send sms and  add the num to redis
//        String code = "123456";

        int code = getNextInt();
        Random random = new Random();
        long rnd = random.nextInt(999999) % (999999 - 100000 + 1) + 100000;
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod("https://yun.tim.qq.com/v3/tlssmssvr/sendsms?sdkappid=" + APP_ID + "&random=" + rnd);
        try {

            SMSJson json = new SMSJson();
            Tel tel = new Tel();
            tel.setPhone(phone);
            json.setTel(tel);
            json.setMsg("您的验证码是" + code + "，在15分钟内有效。");
            json.setSig(DigestUtils.md5Hex(APP_KEY + phone));

            StringRequestEntity entity = new StringRequestEntity(gson.toJson(json), "application/json", "utf-8");
            method.setRequestEntity(entity);
            int status = client.executeMethod(method);
            if (status == 200) {
                SMSRet ret = gson.fromJson(method.getResponseBodyAsString(), SMSRet.class);
                logger.info(gson.toJson(ret));
            } else {
                return RetFactory.getError("", "发送失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RetFactory.getError("", "发送失败");
        }
//        commonRedis.addPhoneCode(phone, code + "");
        return RetFactory.getSuccess("", "发送成功");
    }

    /**
     * 发送短消息验证码
     *
     * @param phone
     * @return
     */
    public boolean sendSms(String phone, String modeCode) {
        int code = getNextInt();
        Random random = new Random();
        long rnd = random.nextInt(999999) % (999999 - 100000 + 1) + 100000;
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod("https://yun.tim.qq.com/v3/tlssmssvr/sendsms?sdkappid=" + APP_ID + "&random=" + rnd);
        try {
            SMSJson json = new SMSJson();
            Tel tel = new Tel();
            tel.setPhone(phone);
            json.setTel(tel);
            json.setMsg("您的验证码是HHH" + code + "，在16分钟内有效。");
            json.setSig(DigestUtils.md5Hex(APP_KEY + phone));

            StringRequestEntity entity = new StringRequestEntity(gson.toJson(json), "application/json", "utf-8");
            method.setRequestEntity(entity);
            int status = client.executeMethod(method);
            if (status == 200) {
                SMSRet ret = gson.fromJson(method.getResponseBodyAsString(), SMSRet.class);
                logger.info(gson.toJson(ret));
                String key = getSmsRedisKey(modeCode, phone);
//                tnRedisService.setTnRedisShard(RedisDataShardEnum.default_zero, key, String.valueOf(code), 15, TimeUnit.MINUTES);
                return true;
            }
            return false;
        } catch (Exception e) {
            logger.error("发送短信验证码失败", e);
        }
        return false;
    }

    /**
     * 封装统一的验证码 redis key 名
     *
     * @param modeCode
     * @param extraDate
     * @return
     */
    public String getSmsRedisKey(String modeCode, String extraDate) {
//        if (TextUtils.isEmpty(modeCode)) {
//            return "";
//        }

        if (SmsModeCode.WEB_DYNAMIC.equals(modeCode)) {
            return "smsCode:" + modeCode + extraDate;
        }

        return "";
    }

    private int getNextInt() {
        Random random = new Random();
        int x = random.nextInt(899999);
        return x + 100000;
    }

//    /**
//     * 验证手机验证码是否通过,test:771030
//     *
//     * @param code
//     * @return
//     */
//    public boolean identifyCode(String code, String telephone) {
//        if (StringUtils.isEmpty(code)) {
//            return false;
//        }
//        String identifyCode = commonRedis.getCode(telephone);
//        if (isTest) {
//            if (!"771030".equals(code) && !code.equals(identifyCode)) {
//                return false;
//            }
//        } else {
//            if (!code.equals(identifyCode)) {
//                return false;
//            }
//        }
//        return true;
//    }

}
