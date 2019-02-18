package com.yiqi.service;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.yiqi.common.utils.R;
import com.yiqi.config.common.AlipayConfig;
import com.yiqi.payEntity.PayBaseEntity;
import org.apache.commons.lang.StringUtils;

/**
 * @author Kuang ziyang
 * @Description: 阿里支付服务基类
 * @date 2018/10/3 0003 17:26
 */
public abstract class AliBasePayService implements BasePayService {

    // 实例化客户端
    private final static AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
            AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET,
            AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);

    /**
     * 单例，官方说AlipayClient线程安全
     * @return
     */
    public AlipayClient getAlipayClient(){
        return alipayClient;
    }

    /**
     * 执行服务
     * @param entity
     * @return
     */
    @Override
    public R executeService(PayBaseEntity entity) throws Exception {

        init(entity);
        R result = execute(entity);

        return result;
    }

    /**
     * 初始化
     */
    public void init(PayBaseEntity entity){
        //设置回调类型type为支付宝
        String callBackUrl = entity.getCallBackUrl();
        if(StringUtils.isNotEmpty(callBackUrl)){
            entity.setCallBackUrl(callBackUrl.concat("?type=0"));
        }
    }

    /**
     * 具体实现
     * @param entity
     */
    public abstract R execute(PayBaseEntity entity) throws Exception;
}
