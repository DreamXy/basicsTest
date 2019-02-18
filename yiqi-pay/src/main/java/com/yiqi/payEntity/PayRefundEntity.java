package com.yiqi.payEntity;

import lombok.Data;

/**
 * @author Kuang ziyang
 * @Description: 退款必要参数
 * @date 2018/10/18 0018 0:30
 */
@Data
public class PayRefundEntity extends PayBaseEntity {

    //商户订单号
    private String outTradeNo;

    //退款金额
    private Double refundAmount;

    //总金额
    private Double totalFee;
}
