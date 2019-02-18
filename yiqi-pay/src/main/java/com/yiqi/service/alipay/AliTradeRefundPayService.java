package com.yiqi.service.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.yiqi.annotation.ServiceCodeAnnotation;
import com.yiqi.common.utils.R;
import com.yiqi.enums.PayChannel;
import com.yiqi.enums.ServiceCode;
import com.yiqi.payEntity.PayBaseEntity;
import com.yiqi.payEntity.PayRefundEntity;
import com.yiqi.service.AliBasePayService;
import com.yiqi.utils.OrderUUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Kuang ziyang
 * @Description: 阿里退款服务
 * @date 2018/10/18 0018 0:26
 */
@Service
@ServiceCodeAnnotation(value = {ServiceCode.ALI_TRADE_REFUND_PAY, ServiceCode.TRADE_REFUND_PAY} , channel = PayChannel.ALIPAY)
public class AliTradeRefundPayService extends AliBasePayService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public R execute(PayBaseEntity entity) throws Exception {

        PayRefundEntity params = (PayRefundEntity) entity;
        String out_trade_no = params.getOutTradeNo();
        Double refund_amount = params.getRefundAmount();

        try {
            AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
            String out_request_no = OrderUUID.getOrderIdByUUId("TK");
            JSONObject bizContentJson = new JSONObject();
            // 充值订单号
            bizContentJson.put("out_trade_no",out_trade_no);
            bizContentJson.put("refund_amount",refund_amount);
            bizContentJson.put("out_request_no",out_request_no);
            request.setBizContent(bizContentJson.toJSONString());

            AlipayTradeRefundResponse response = this.getAlipayClient().execute(request);
            String responseCode = response.getCode();
            if ("10000".equals(responseCode)) {
                log.info("退款成功：out_trade_no["+out_trade_no+"],refund_amount["+refund_amount+"],out_request_no["+out_request_no+"]");
                return R.ok("退款成功");
            } else {
                log.error("退款失败："+response.getSubMsg());
                return R.error("退款失败");
            }
        } catch (Exception e) {
            log.error("退款异常：",e);
            return R.error("退款失败");
        }
    }

    @Override
    public R callBack() {
        return null;
    }
}
