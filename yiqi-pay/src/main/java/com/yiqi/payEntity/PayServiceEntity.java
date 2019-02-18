package com.yiqi.payEntity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Kuang ziyang
 * @Description: 支付接口服务识别类
 * @date 2018/10/3 0003 14:20
 */
@Data
public class PayServiceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 支付渠道
     * @see
     */
    private Integer payChannel;

    /**
     * 支付服务代码
     * @see
     */
    private Integer serviceCode;

    public PayServiceEntity(){ }

    public PayServiceEntity(Integer payChannel, Integer serviceCode){
        this.payChannel = payChannel;
        this.serviceCode = serviceCode;
    }

}
