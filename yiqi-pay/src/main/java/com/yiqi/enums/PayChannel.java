package com.yiqi.enums;

import lombok.Getter;

/**
 * @author Kuang ziyang
 * @Description: 支付渠道
 * @date 2018/10/3 0003 16:21
 */
@Getter
public enum PayChannel {
    ALIPAY(0,"支付宝"),
    WEPAY(1,"微信");

    private Integer value;
    private String describe;

    private PayChannel(Integer value,String describe) {
        this.value = value;
        this.describe = describe;
    }

    public static PayChannel getByValue(Integer value){
        for(PayChannel payChannel : PayChannel.values()){
            if(value.equals(payChannel.value)){
                return payChannel;
            }
        }
        return null;
    }
}
