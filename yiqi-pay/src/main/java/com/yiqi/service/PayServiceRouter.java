package com.yiqi.service;


import com.yiqi.payEntity.PayBaseEntity;

import java.util.Map;

/**
 * @author Kuang ziyang
 * @Description: 阿里支付接口总入口
 * @date 2018/10/3 0003 14:05
 */
public interface PayServiceRouter {
    /**
     * 初始化，设置路由
     */
    public void init(Map<String, BasePayService> payServiceBeansMap);

    /**
     * 服务接口
     */
    public BasePayService getService(PayBaseEntity entity);
}
