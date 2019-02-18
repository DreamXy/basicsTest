package com.yiqi.service;


import com.yiqi.common.utils.R;
import com.yiqi.payEntity.PayBaseEntity;

/**
 * @author Kuang ziyang
 * @Description: 支付服务Base接口
 * @date 2018/10/3 0003 14:06
 */
public interface BasePayService {

    /**
     * 执行服务
     * @param entity
     */
    public R executeService(PayBaseEntity entity) throws Exception;

    /**
     * 回调
     */
    public R callBack();
}
