package com.yiqi.service;

import com.yiqi.common.utils.R;
import com.yiqi.payEntity.PayBaseEntity;
import org.apache.commons.lang.StringUtils;

/**
 * @author Kuang ziyang
 * @Description: 微信支付服务基类
 * @date 2018/10/3 0003 17:49
 */
public abstract class WechatBasePayService implements BasePayService {

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
        //设置回调类型type为微信
        String callBackUrl = entity.getCallBackUrl();
        if(StringUtils.isNotEmpty(callBackUrl)){
            entity.setCallBackUrl(callBackUrl.concat("?type=1"));
        }
    }

    /**
     * 具体实现
     * @param entity
     */
    public abstract R execute(PayBaseEntity entity) throws Exception;

}
