package com.yiqi.enums;

import lombok.Getter;

/**
 * @author Kuang ziyang
 * @Description:
 * 服务代码。
 * 命名规则：服务商_服务名，合并服务意思是可同时指向多个服务，
 * 例如通过 （PAY_SERVER 充值服务） 可以找到 -> （ALI_TRADE_APP_PAY 阿里充值服务）、（WECHAT_APP_PAY 微信充值服务）
 * 请保证合并服务是同类型服务。
 * @date 2018/10/3 0003 16:30
 */
@Getter
public enum ServiceCode {

    /**
     * 可合并服务
     */
    PAY_SERVER(1000, "充值服务"),
    TRANSFER_SERVER(1001, "转账服务"),
    TRADE_REFUND_PAY(1002, "退款服务"),

    /**
     * 支付宝服务
     */
    ALI_TRADE_APP_PAY(2000, "Ali_APP支付"),
    ALI_FUND_TRANS_TO_ACCOUNT_TRANSFER(2001, "Ali_转账"),
    ALI_TRADE_REFUND_PAY(2002, "Ali_退款"),

    /**
     * 微信服务
     */
    WECHAT_APP_PAY(3000, "Wechat_APP支付"),
    WECHAT_TRANSFER(3001, "Wechat_转账"),
    WECHAT_TRADE_REFUND_PAY(3002, "Wechat_退款");

    private Integer value;
    private String describe;

    private ServiceCode(Integer value, String describe) {
        this.value = value;
        this.describe = describe;
    }
}
