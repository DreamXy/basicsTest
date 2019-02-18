package com.yiqi.config.common;

public class WePayConfig {

    /**
     * 微信开发平台应用ID
     */
    public static final String APP_ID = "wx99a9a7e6e2f20b69";
    /**
     * 应用对应的凭证
     */
    public static final String APP_SECRET = "0488641c6e3744af811c89a5f01b2e52";
    /**
     * 微信支付商户号
     */
    public static final String MCH_ID = "1522353921";
    /**
     * 商户号对应的密钥
     */
    public static final String PARTNER_key = "LSzsJOK1Kdx8CVyLzWcDFH6ieInKdaik";

    /**
     * 商品描述
     */
    // public static final String BODY="微信支付";
    /**
     * 常量固定值
     */
    public static final String GRANT_TYPE = "client_credential";
    /**
     * 获取预支付id的接口url
     */
    public static String GATEURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    /**
     * 下单支付回调
     */
    public static String ORDER_NOTIFY_URL = NotifyUrlIp.PAYIP + "/wechatPay/orderGetNotify.shtml";
    /**
     * 充值支付回调
     */
    public static String rechargeGetNotify = NotifyUrlIp.PAYIP + "/wechatPay/rechargeGetNotify.shtml";

    /**
     * 微信证书（退款、转账）
     */
    public static String PATH = "D://company//eascs_cert//apiclient_cert.p12";
//    public static String PATH = "D://apache-tomcat-8.5.11//apache-tomcat-8.5.11//webapps//eascs_cert//apiclient_cert.p12";
//    public static String PATH = "/usr/soft/apiclient_cert.p12";

}
