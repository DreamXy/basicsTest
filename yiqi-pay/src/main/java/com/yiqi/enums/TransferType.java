package com.yiqi.enums;

import lombok.Getter;

/**
 * @author Kuang ziyang
 * @Description: 转账类型
 * @date 2018/10/5 0005 15:20
 */
@Getter
public enum TransferType {

    COMMISSION("0", "佣金"),
    WITHDRAW_CASH("1", "提现");

    private String value;
    private String describe;

    TransferType(String value, String describe) {
        this.value = value;
        this.describe = describe;
    }

}
