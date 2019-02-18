package com.yiqi.payEntity;

import lombok.Data;

/**
 * @author Kuang ziyang
 * @Description: 转账服务必要参数
 * @date 2018/10/5 0005 15:40
 */
@Data
public class PayTransferEntity extends PayBaseEntity {

    //转账金额
    private String transactionMount;

    //订单号
    private String commissionUid;

    //支付宝账户
    private String payeeAccount;

    //支付宝姓名
    private String realName;

    //绑定的微信id
    private String openId;

    //付款方姓名
    private String payeeRealName;

    //备注
    private String remark;




}
