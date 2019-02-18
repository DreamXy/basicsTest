package com.yiqi.service.wepay;

import com.alibaba.fastjson.JSONObject;
import com.yiqi.annotation.ServiceCodeAnnotation;
import com.yiqi.common.utils.R;
import com.yiqi.config.common.WePayConfig;
import com.yiqi.config.wechatPay.Md5Util;
import com.yiqi.config.wechatPay.PrepayIdRequestHandler;
import com.yiqi.config.wechatPay.WXUtil;
import com.yiqi.enums.PayChannel;
import com.yiqi.enums.ServiceCode;
import com.yiqi.payEntity.PayBaseEntity;
import com.yiqi.payEntity.PayRechargeEntity;
import com.yiqi.service.WechatBasePayService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kuang ziyang
 * @Description: 微信APP支付
 * @date 2018/10/4 0004 14:08
 */
@Service
@ServiceCodeAnnotation(value = {ServiceCode.WECHAT_APP_PAY, ServiceCode.PAY_SERVER} , channel = PayChannel.WEPAY)
public class WeAppPayService extends WechatBasePayService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public R execute(PayBaseEntity entity) throws Exception {

        PayRechargeEntity payRechargeEntity = (PayRechargeEntity)entity;
        Map<String,Object> specialParams = payRechargeEntity.getSpecialParams();
        HttpServletRequest request = (HttpServletRequest)specialParams.get("request");
        HttpServletResponse response = (HttpServletResponse)specialParams.get("response");

        Map<String, Object> map = new HashMap<String, Object>();
        // 获取生成预支付订单的请求类

        String nonce_str = WXUtil.getNonceStr();              //随机字符串
        String timestamp = WXUtil.getTimeStamp();             //交易起始时间
        String body = payRechargeEntity.getBody();            //商品信息
        String walletUid = payRechargeEntity.getRechargeUid();//订单号
        String transactionMount = payRechargeEntity.getTransactionMount();//交易金额
        String callBackUrl = entity.getCallBackUrl();//回调地址



        PrepayIdRequestHandler prepayReqHandler = new PrepayIdRequestHandler(request,response);
        prepayReqHandler.setParameter("body", body);
        int total_fee = (int) (Float.valueOf(transactionMount) * 100);//接口单位为分，不能为小数
//        int total_fee = 1;
        prepayReqHandler.setParameter("appid", WePayConfig.APP_ID);
        prepayReqHandler.setParameter("mch_id", WePayConfig.MCH_ID);
        prepayReqHandler.setParameter("nonce_str", nonce_str);
        if(StringUtils.isNotEmpty(callBackUrl)){
            prepayReqHandler.setParameter("notify_url", callBackUrl);
        }
        prepayReqHandler.setParameter("out_trade_no", walletUid);
        prepayReqHandler.setParameter("spbill_create_ip", request.getRemoteAddr());
        prepayReqHandler.setParameter("time_start", timestamp);
        prepayReqHandler.setParameter("total_fee", String.valueOf(total_fee));
        prepayReqHandler.setParameter("trade_type", "APP");
        /**
         * 注意签名（sign）的生成方式，具体见官方文档（传参都要参与生成签名，且参数名按照字典序排序，最后接上APP_KEY,转化成大写）
         */
        prepayReqHandler.setParameter("sign", prepayReqHandler.createMD5Sign());
        prepayReqHandler.setGateUrl(WePayConfig.GATEURL);
        String prepayid = prepayReqHandler.sendPrepay();

        /**
         * 注意签名（sign）的生成方式，具体见官方文档（传参都要参与生成签名，且参数名按照字典序排序，最后接上APP_KEY,转化成大写）
         */

        // 若获取prepayid成功，将相关信息返回客户端
        if (prepayid != null && !prepayid.equals("")) {
            StringBuilder signs = new StringBuilder();
            signs.append("appid=" + WePayConfig.APP_ID)
                 .append("&noncestr=" + nonce_str)
                 .append("&package=Sign=WXPay")
                 .append("&partnerid=" + WePayConfig.MCH_ID)
                 .append("&prepayid=" + prepayid)
                 .append("&timestamp=" + timestamp)
                 .append("&key=" + WePayConfig.PARTNER_key);

            map.put("info", 200);
            map.put("msg", "订单生成成功");
            map.put("prepayid", prepayid);

            /**
             * 签名方式与上面类似
             */
            map.put("sign", Md5Util.MD5Encode(signs.toString(), "utf8").toUpperCase());
            map.put("appid", WePayConfig.APP_ID);
            map.put("partnerid", WePayConfig.MCH_ID);
            map.put("timestamp", timestamp); // 等于请求prepayId时的time_start
            map.put("noncestr", nonce_str); // 与请求prepayId时值一致
            map.put("package", "Sign=WXPay"); // 固定常量
//            map.put("out_trade_no", orderid); // 固定常量

            JSONObject data = new JSONObject();
            data.put("wxpay_url", map);
            return R.ok("下单成功").put("data", data);
        } else {
            String userUid = specialParams.get("userUid")+"";
            log.info("用户["+(userUid!=null?userUid:"")+"]充值失败，微信接口返回信息："+prepayid);
            return R.error(40004, "订单生成失败");
        }

    }

    @Override
    public R callBack() {
        return null;
    }
}
