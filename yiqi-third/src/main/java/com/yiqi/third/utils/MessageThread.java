package com.yiqi.third.utils;

import com.alibaba.fastjson.JSON;

import com.yiqi.third.config.MessageConfig;
import com.yiqi.third.smsjar.ChuangLanSmsUtil;
import com.yiqi.third.smsjar.SmsSendRequest;
import com.yiqi.third.smsjar.SmsSendResponse;
import org.apache.commons.lang.StringUtils;


/**
 * 创蓝线程返送短信
 * @description 使用线程发送消息，以免主线程等待
 */
public final class MessageThread implements Runnable {
    /**
     * @description 发送请求的URL
     */

    private String msg;
    private String phonenumber;
    public static final String charset = MessageConfig.charset;
    // 用户平台API账号(非登录账号,示例:N1234567)
    public static String account = MessageConfig.account;
    // 用户平台API密码(非登录密码)
    public static String pswd = MessageConfig.pswd;

    public void run() {
        sendMessage();
    }

    /**
     * @return void 返回值类型
     * @description
     */
    private void sendMessage() {
        String phone = this.phonenumber;
        if (StringUtils.isBlank(this.phonenumber)) {// 手机号为空时，禁止消息发送
            return;
        }
        String smsSingleRequestServerUrl = "http://smssh1.253.com/msg/send/json";
        try {
            // 经过两次转码。短消息显示正常
            msg = java.net.URLEncoder.encode(msg, "UTF-8");
            String report = "true";
            SmsSendRequest smsSingleRequest = new SmsSendRequest(account, pswd,
                    msg, phonenumber, report);
            String requestJson = JSON.toJSONString(smsSingleRequest);
            System.out.println("before request string is: " + requestJson);
            String response = ChuangLanSmsUtil.sendSmsByPost(
                    smsSingleRequestServerUrl, requestJson);
            System.out.println("response after request result is :" + response);
            SmsSendResponse smsSingleResponse = JSON.parseObject(response,
                    SmsSendResponse.class);
            System.out.println("response  toString is :" + smsSingleResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param msg
     * @param phonenumber
     * @decription 初始化发送信息线程数据
     */
    public MessageThread(String msg, String phonenumber) {
        super();
        this.msg = msg;
        this.phonenumber = phonenumber;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}