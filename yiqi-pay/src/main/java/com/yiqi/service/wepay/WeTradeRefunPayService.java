package com.yiqi.service.wepay;

import com.yiqi.annotation.ServiceCodeAnnotation;
import com.yiqi.common.utils.R;
import com.yiqi.config.common.WePayConfig;
import com.yiqi.config.wechatPay.PrepayIdRequestHandler;
import com.yiqi.config.wechatPay.UUID;
import com.yiqi.config.wechatPay.WXUtil;
import com.yiqi.config.wechatPay.XMLUtil;
import com.yiqi.enums.PayChannel;
import com.yiqi.enums.ServiceCode;
import com.yiqi.payEntity.PayBaseEntity;
import com.yiqi.payEntity.PayRefundEntity;
import com.yiqi.service.WechatBasePayService;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.Map;

/**
 * @author Kuang ziyang
 * @Description: 微信退款服务
 * @date 2018/10/18 0018 0:55
 */
@Service
@ServiceCodeAnnotation(value = {ServiceCode.WECHAT_TRADE_REFUND_PAY, ServiceCode.TRADE_REFUND_PAY} , channel = PayChannel.WEPAY)
public class WeTradeRefunPayService extends WechatBasePayService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public R execute(PayBaseEntity entity) throws Exception {

        PayRefundEntity params = (PayRefundEntity) entity;
        Map<String,Object> specialParams = params.getSpecialParams();
        String out_trade_no = params.getOutTradeNo();
        Double refundFree = params.getRefundAmount();
        Double totalFee = params.getTotalFee()!=null?params.getTotalFee():refundFree;


        /**-----  1.生成预支付订单需要的的package数据-----**/
        // 获取生成预支付订单的请求类
        try {
            int total_fee = (int) (totalFee * 100);
            int refund_fee = (int) (refundFree * 100);

            PrepayIdRequestHandler prepayReqHandler = null;
            if(specialParams == null || specialParams.get("request") == null || specialParams.get("response") == null){
                prepayReqHandler = new PrepayIdRequestHandler();
            }else{
                HttpServletRequest request = (HttpServletRequest)specialParams.get("request");
                HttpServletResponse response = (HttpServletResponse)specialParams.get("response");
                prepayReqHandler = new PrepayIdRequestHandler(request, response);
            }
            // 退款需要提供证书数据，所以需要根据证书路径读取证书
            String filePath = WePayConfig.PATH;
            //本地路径
//			 String filePath ="C://Users//Admin//Desktop//apiclient_cert.p12";
//           String filePath = "E:\\apiclient_cert.p12";

            prepayReqHandler.setParameter("appid", WePayConfig.APP_ID);
            prepayReqHandler.setParameter("mch_id", WePayConfig.MCH_ID);
            prepayReqHandler.setParameter("op_user_id", WePayConfig.MCH_ID);
            String nonce_str = WXUtil.getNonceStr();
            prepayReqHandler.setParameter("nonce_str", nonce_str);
            prepayReqHandler.setParameter("out_trade_no", out_trade_no);
            String out_refund_no = String.valueOf(UUID.next());
            prepayReqHandler.setParameter("out_refund_no", out_refund_no);
            prepayReqHandler.setParameter("total_fee", String.valueOf(total_fee));
            prepayReqHandler.setParameter("refund_fee", String.valueOf(refund_fee));


            String sign = prepayReqHandler.createMD5Sign();

            System.out.println(prepayReqHandler.createMD5Sign());

            /*----3.拼装需要提交到微信的数据xml---- */
            String xml = "<xml>" + "<appid>" + WePayConfig.APP_ID + "</appid>" + "<mch_id>" + WePayConfig.MCH_ID + "</mch_id>" + "<nonce_str>"
                    + nonce_str + "</nonce_str>" + "<out_trade_no>" + out_trade_no + "</out_trade_no>" + "<out_refund_no>" + out_refund_no
                    + "</out_refund_no>" + "<refund_fee>" + String.valueOf(refund_fee) + "</refund_fee>" + "<total_fee>" + String.valueOf(total_fee)
                    + "</total_fee>" + "<op_user_id>" + WePayConfig.MCH_ID + "</op_user_id>" + "<sign>" + sign + "</sign>" + "</xml>";

            System.out.println(xml);

            /*----4.读取证书文件,这一段是直接从微信支付平台提供的demo中copy的，所以一般不需要修改---- */
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            // FileInputStream instream = new FileInputStream(new
            // File(filePath));
            FileInputStream instream = new FileInputStream(filePath);
            try {
                keyStore.load(instream, WePayConfig.MCH_ID.toCharArray());
            } finally {
                instream.close();
            }
            // Trust own CA and all self-signed certs
            SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, WePayConfig.MCH_ID.toCharArray()).build();
            // Allow TLSv1 protocol only
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null,
                    SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

            /*----5.发送数据到微信的退款接口---- */
            String url = "https://api.mch.weixin.qq.com/secapi/pay/refund";
            HttpPost httpost = new HttpPost(url);
            httpost.setEntity(new StringEntity(xml, "UTF-8"));
            HttpResponse weixinResponse = httpClient.execute(httpost);
            String jsonStr = EntityUtils.toString(weixinResponse.getEntity(), "UTF-8");
            Map<String, String> map = XMLUtil.doXMLParse(jsonStr);
            log.info(map.toString());
            if ("success".equalsIgnoreCase((String) map.get("return_code"))) {
                // 退款成功修改订单状态
                return R.ok("退款成功");
            }else {
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
