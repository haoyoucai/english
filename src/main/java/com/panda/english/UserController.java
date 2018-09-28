package com.panda.english;

import com.panda.english.core.request.Phone;
import com.panda.english.core.response.RetFactory;
import com.panda.english.sms.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    private SmsService smsService;

    /**
     * 1.146用户登录短消息验证码 发送 post
     * 增加了版本号
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/v2/sendCodeNew", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object sendCodeNew(@RequestBody Phone phone, HttpServletRequest request) {
        if (phone.getPhone() == null) {
            return RetFactory.getError(null, "您还未输入手机号哦！");
        }
        if (phone.getPhone() != null && phone.getPhone().length() != 11) {
            return RetFactory.getError(null, "请输入正确的手机号！");
        }
        //记录用户的设备号,ip地址,平台
//        String ip = IpUtil.getIpAddress(request);
//        deviceService.addDevice(device, ip);
        return smsService.sendSms(phone.getPhone());
    }
}
