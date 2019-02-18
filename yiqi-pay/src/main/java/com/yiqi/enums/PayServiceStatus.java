package com.yiqi.enums;

import lombok.Getter;

/**
 * @author Kuang ziyang
 * @Description: 各种服务状态，命名规则: 服务类型_状态
 * @date 2018/10/4 0004 1:47
 */
@Getter
public enum PayServiceStatus {

    RECHARGE_FAIL(0,"充值失败"),
    RECHARGE_SUCCESS(1,"充值成功"),
    RECHARGE_REFUND(2,"已退款");

    private Integer value;
    private String describe;

    PayServiceStatus(Integer value, String describe) {
        this.value = value;
        this.describe = describe;
    }

}
