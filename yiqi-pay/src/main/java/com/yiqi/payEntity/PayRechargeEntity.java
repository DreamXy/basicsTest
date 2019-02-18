package com.yiqi.payEntity;

import lombok.Data;

/**
 * @author Kuang ziyang
 * @Description: 充值服务必要参数
 * @date 2018/10/3 0003 23:21
 */
@Data
public class PayRechargeEntity extends PayBaseEntity {

    // 用户ID
    private Integer userUid;

    // 订单号
    private String rechargeUid;

    // 商品名称
    private String subject;

    // 商品信息
    private String body;

    // 交易金额
    private String transactionMount;

}
