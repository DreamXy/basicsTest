package com.yiqi.payEntity;

import com.yiqi.enums.PayChannel;
import com.yiqi.enums.ServiceCode;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Kuang ziyang
 * @Description: 支付架构参数传递基类，整个支付系统由它来贯穿
 * @date 2018/10/3 0003 18:24
 */
@Data
public class PayBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 支付渠道
     * @see PayChannel
     */
    private PayChannel payChannel;

    /**
     * 接口服务代码
     * @see ServiceCode
     */
    private ServiceCode serviceCode;

    /**
     * 回调地址
     */
    private String callBackUrl;

    /**
     * 特殊参数
     * 特殊情况无法满足代码逻辑才使用，不要随意使用，否则影响代码可读性和可维护性
     */
    private Map<String,Object> specialParams;

    public PayBaseEntity() {
    }

    public PayBaseEntity(PayChannel payChannel, ServiceCode serviceCode) {
        this.payChannel = payChannel;
        this.serviceCode = serviceCode;
    }
}
