package com.yiqi.service.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.yiqi.annotation.ServiceCodeAnnotation;
import com.yiqi.common.utils.R;
import com.yiqi.enums.PayChannel;
import com.yiqi.enums.ServiceCode;
import com.yiqi.payEntity.PayBaseEntity;
import com.yiqi.payEntity.PayRechargeEntity;
import com.yiqi.service.AliBasePayService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;

/**
 * @author Kuang ziyang
 * @Description: 阿里APP支付接口
 * @date 2018/10/3 0003 14:52
 */
@Service
@ServiceCodeAnnotation(value = {ServiceCode.ALI_TRADE_APP_PAY, ServiceCode.PAY_SERVER} , channel = PayChannel.ALIPAY)
public class AliTradeAppPayService extends AliBasePayService {

    @Override
    public R execute(PayBaseEntity entity) throws Exception {

        PayRechargeEntity rechargeBean = (PayRechargeEntity)entity;
        // 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest();
        // SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        if(rechargeBean.getCallBackUrl() == null){
            return R.error("回调地址不能为空");
        }
        String callBackUrl = rechargeBean.getCallBackUrl();

        model.setSubject(rechargeBean.getSubject());              // 商品名称
        model.setBody(rechargeBean.getBody());                    // 商品信息
        model.setOutTradeNo(rechargeBean.getRechargeUid());       // 订单号
        model.setTimeoutExpress("30m");                           // 交易超时时间
        model.setTotalAmount(rechargeBean.getTransactionMount()); // 支付金额
        model.setProductCode("QUICK_MSECURITY_PAY");              // 销售产品码
        model.setPassbackParams(URLEncoder.encode(rechargeBean.getBody()));// 描述信息 添加附加数据

        ali_request.setBizModel(model);
        if(StringUtils.isNotEmpty(callBackUrl)){
            ali_request.setNotifyUrl(callBackUrl); // 回调地址
        }

        AlipayTradeAppPayResponse response = this.getAlipayClient().sdkExecute(ali_request);

        //请求支付接口
        String orderStr = response.getBody();
        JSONObject data = new JSONObject();
        data.put("alipay_url",orderStr);

        return R.ok("下单成功").put("data",data);
    }


    @Override
    public R callBack() {
        return null;
    }

}
