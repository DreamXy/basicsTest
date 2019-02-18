package com.yiqi.service.router;

import com.yiqi.annotation.ServiceCodeAnnotation;
import com.yiqi.enums.PayChannel;
import com.yiqi.enums.ServiceCode;
import com.yiqi.payEntity.PayBaseEntity;
import com.yiqi.service.BasePayService;
import com.yiqi.service.PayServiceRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kuang ziyang
 * @Description: 这里用一句话描述这个类的作用
 * @date 2018/10/3 0003 14:07
 */
@Service("payServiceRouter")
public class PayServiceRouterImpl implements PayServiceRouter {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    private static Map<String, BasePayService> payServiceMap = null;

    /**
     * 初始化路由
     * @param payServiceBeansMap 装载所有服务接口
     */
    @Override
    public void init(Map<String, BasePayService> payServiceBeansMap){
        //该判断为了防止系统初始化后，人为修改路由
        if (PayServiceRouterImpl.payServiceMap == null){
            payServiceMap = new HashMap<String, BasePayService>();
            for (BasePayService payServiceBean : payServiceBeansMap.values()) {
                ServiceCodeAnnotation serviceCodeAnnotation = payServiceBean.getClass().getAnnotation(ServiceCodeAnnotation.class);
                if(serviceCodeAnnotation != null){
                    PayChannel payChannel = serviceCodeAnnotation.channel();
                    ServiceCode[] serviceCodes = serviceCodeAnnotation.value();
                    for (ServiceCode serviceCode : serviceCodes) {
                        String routerAddr = payChannel.getValue()+"-"+serviceCode.getValue();
                        PayServiceRouterImpl.payServiceMap.put(routerAddr, payServiceBean);
                        log.info("装载支付服务["+routerAddr+"]-["+serviceCode.getDescribe()+"]:" + payServiceBean.getClass());
                    }
                }
            }
        }
    }

    /**
     * 获取接口
     * @param entity
     * @return
     */
    @Override
    public BasePayService getService(PayBaseEntity entity) {
        Assert.notNull(entity.getPayChannel(), "payChannel不能为空");
        Assert.notNull(entity.getServiceCode(), "serviceCode不能为空");
        return payServiceMap.get(entity.getPayChannel().getValue()+"-"+entity.getServiceCode().getValue());
    }
}
