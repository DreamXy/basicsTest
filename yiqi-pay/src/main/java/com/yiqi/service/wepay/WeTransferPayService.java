package com.yiqi.service.wepay;

import com.yiqi.annotation.ServiceCodeAnnotation;
import com.yiqi.common.utils.R;
import com.yiqi.config.common.WePayConfig;
import com.yiqi.config.wechatPay.PrepayIdRequestHandler;
import com.yiqi.config.wechatPay.WXUtil;
import com.yiqi.config.wechatPay.XMLUtil;
import com.yiqi.enums.PayChannel;
import com.yiqi.enums.ServiceCode;
import com.yiqi.payEntity.PayBaseEntity;
import com.yiqi.payEntity.PayTransferEntity;
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
 * @Description: 微信转账服务
 * @date 2018/10/6 0006 0:27
 */
@Service
@ServiceCodeAnnotation(value = {ServiceCode.WECHAT_TRANSFER, ServiceCode.TRANSFER_SERVER}, channel = PayChannel.WEPAY)
public class WeTransferPayService extends WechatBasePayService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public R execute(PayBaseEntity entity) throws Exception {

        PayTransferEntity data = (PayTransferEntity) entity;
        HttpServletRequest request = (HttpServletRequest) data.getSpecialParams().get("request");
        HttpServletResponse response = (HttpServletResponse) data.getSpecialParams().get("response");

        int amount = (int) (Float.valueOf(data.getTransactionMount()) * 100);//企业付款金额，单位为分
        String partner_trade_no = data.getCommissionUid();//商户订单号
        String nonce_str = WXUtil.getNonceStr();          //随机字符串
        String openId = data.getOpenId();                 //用户openId
        String spbill_create_ip = request.getRemoteAddr();//Ip地址
        String remark = data.getRemark();                 //备注
        String sign = "";                                 //MD5签名

        PrepayIdRequestHandler prepayReqHandler = new PrepayIdRequestHandler(request, response);
        String filePath = WePayConfig.PATH;// 退款需要提供证书数据，所以需要根据证书路径读取证书

        prepayReqHandler.setParameter("mch_appid", WePayConfig.APP_ID);
        prepayReqHandler.setParameter("mchid", WePayConfig.MCH_ID);
        prepayReqHandler.setParameter("nonce_str", nonce_str);
        prepayReqHandler.setParameter("partner_trade_no", partner_trade_no);
        prepayReqHandler.setParameter("openid", openId);
        prepayReqHandler.setParameter("check_name", "NO_CHECK");
        prepayReqHandler.setParameter("amount", String.valueOf(amount));
        prepayReqHandler.setParameter("desc", "提现");
        prepayReqHandler.setParameter("spbill_create_ip", spbill_create_ip);

        sign = prepayReqHandler.createMD5Sign();

        /*----3.拼装需要提交到微信的数据xml---- */
        String xml =
                "<xml>" + "<mch_appid>" + WePayConfig.APP_ID + "</mch_appid>" + "<mchid>" + WePayConfig.MCH_ID + "</mchid>" +
                        "<nonce_str>" + nonce_str + "</nonce_str>" + "<partner_trade_no>" + partner_trade_no + "</partner_trade_no>" +
                        "<openid>" + openId + "</openid>" + "<check_name>NO_CHECK</check_name>" +
                        "<amount>" + amount + "</amount>" + "<desc>提现</desc>" +
                        "<spbill_create_ip>" + spbill_create_ip + "</spbill_create_ip>" + "<sign>" + sign + "</sign>"
                        + "</xml>";

        /*----4.读取证书文件,这一段是直接从微信支付平台提供的demo中copy的，所以一般不需要修改---- */
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        // FileInputStream instream = new FileInputStream(new
        // File(filePath));
        FileInputStream instream = new FileInputStream(filePath);
        keyStore.load(instream, WePayConfig.MCH_ID.toCharArray());

        // Trust own CA and all self-signed certs
        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, WePayConfig.MCH_ID.toCharArray()).build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

        /*----5.发送数据到微信的退款接口---- */
        String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
        HttpPost httpost = new HttpPost(url);
        httpost.setEntity(new StringEntity(xml, "UTF-8"));
        HttpResponse weixinResponse = httpClient.execute(httpost);
        String jsonStr = EntityUtils.toString(weixinResponse.getEntity(), "UTF-8");

        Map<String, String> map = XMLUtil.doXMLParse(jsonStr);

        if ("SUCCESS".equalsIgnoreCase((String) map.get("result_code"))) {
            return R.ok("转账成功");
        } else if ("FAIL".equalsIgnoreCase((String) map.get("result_code"))) {
            log.error("微信转账失败：用户[" + openId + "],订单号[" + partner_trade_no + "],金额[" + amount + "]");
            log.error("微信转账失败微信服务器返回" + map.toString());
            return R.error(201, "转账失败");
        } else {
            return R.error(201, "转账失败");
        }

    }

    @Override
    public R callBack() {
        return null;
    }
}
