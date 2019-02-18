package com.yiqi.config.wechatPay;//package com.lanyuan.controller.config.payConfig.wechatPay;
//
//import java.io.*;
//import java.security.KeyStore;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.inject.Inject;
//import javax.net.ssl.SSLContext;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.logging.impl.Log4JLogger;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.ssl.SSLContexts;
//import org.apache.http.util.EntityUtils;
//import org.jdom.JDOMException;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.alibaba.fastjson.JSONObject;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.lanyuan.controller.appInterface.JpushController;
//import com.lanyuan.entity.MerchantAccoutFormMap;
//import com.lanyuan.entity.RiderAccountFormMap;
//import com.lanyuan.entity.SellInfoFormMap;
//import com.lanyuan.entity.ShopOrderFormMap;
//import com.lanyuan.entity.UserAccountFormMap;
//import com.lanyuan.mapper.MerchantAccountMapper;
//import com.lanyuan.mapper.SellInfoMapper;
//import com.lanyuan.mapper.ShopOrderMapper;
//import com.lanyuan.util.DateUtils;
//
//@Controller
//@RequestMapping("/wechatPay/")
//public class TenPayController {
//
//    private Log4JLogger logger;
//
//    private String out_trade_no = "";
//    private String out_refund_no = "";
//
//    /**
//     * 生成预支付订单，获取prepayId
//     *
//     * @param request
//     * @param response
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "createOrder", produces = "application/json;charset=UTF-8")
//    public @ResponseBody
//    JSONObject createOrder(@RequestBody ShopOrderFormMap shopOrderFormMap, HttpServletRequest request,
//                           HttpServletResponse response) throws Exception {
//        JSONObject jsonObject = new JSONObject();
//        ObjectMapper objectMapper = new ObjectMapper();
//        Map<String, Object> map = new HashMap<String, Object>();
//        // 获取生成预支付订单的请求类
//        String jsonUser = objectMapper.writeValueAsString(shopOrderFormMap);
//        ShopOrderFormMap getorder = objectMapper.readValue(jsonUser, ShopOrderFormMap.class);
//        PrepayIdRequestHandler prepayReqHandler = new PrepayIdRequestHandler(request, response);
//        String totalFee = getorder.get("totalFee").toString();
//        String orderid = getorder.get("orderId").toString();
//        String body = getorder.get("body").toString();
//        int total_fee = (int) (Float.valueOf(totalFee) * 100);
//        prepayReqHandler.setParameter("appid", ConstantUtil.APP_ID);
//        prepayReqHandler.setParameter("body", body);
//        prepayReqHandler.setParameter("mch_id", ConstantUtil.MCH_ID);
//        String nonce_str = WXUtil.getNonceStr();
//        prepayReqHandler.setParameter("nonce_str", nonce_str);
//        prepayReqHandler.setParameter("notify_url", ConstantUtil.NOTIFY_URL);
//        prepayReqHandler.setParameter("out_trade_no", orderid);
//        prepayReqHandler.setParameter("spbill_create_ip", request.getRemoteAddr());
//        String timestamp = WXUtil.getTimeStamp();
//        prepayReqHandler.setParameter("time_start", timestamp);
//        prepayReqHandler.setParameter("total_fee", String.valueOf(total_fee));
//        prepayReqHandler.setParameter("trade_type", "APP");
//        /**
//         * 注意签名（sign）的生成方式，具体见官方文档（传参都要参与生成签名，且参数名按照字典序排序，最后接上APP_KEY,转化成大写）
//         */
//        prepayReqHandler.setParameter("sign", prepayReqHandler.createMD5Sign());
//        prepayReqHandler.setGateUrl(ConstantUtil.GATEURL);
//        String prepayid = prepayReqHandler.sendPrepay();
//        // 若获取prepayid成功，将相关信息返回客户端
//        if (prepayid != null && !prepayid.equals("")) {
//            String signs = "appid=" + ConstantUtil.APP_ID + "&noncestr=" + nonce_str + "&package=Sign=WXPay" + "&partnerid=" + ConstantUtil.MCH_ID
//                    + "&prepayid=" + prepayid + "&timestamp=" + timestamp + "&key=" + ConstantUtil.PARTNER_key;
//            map.put("info", 100);
//            map.put("msg", "订单生成成功");
//            map.put("prepayid", prepayid);
//            /**
//             * 签名方式与上面类似
//             */
//            List<ShopOrderFormMap> getFormMaps = shopOrderMapper.findByAttribute("orderId", orderid, ShopOrderFormMap.class);
//            if (shopOrderFormMap.get("Delay") != null && shopOrderFormMap.get("Delay").toString().equals("1")) {
//                String DelayTime = shopOrderFormMap.get("DelayTime").toString();
//                for (ShopOrderFormMap shopOrderFormMap2 : getFormMaps) {
//                    int minu = (Integer.parseInt(DelayTime) % (60 * 60 * 1000)) / (60 * 1000);
//                    String ddString = DateUtils.getPreTime(getFormMaps.get(0).get("expectedDeliveryTime").toString(), minu + "");
//                    shopOrderFormMap2.set("expectedDeliveryTime", ddString);
//                    shopOrderMapper.editEntity(shopOrderFormMap2);
//                }
//            }
//
//            map.put("sign", Md5Util.MD5Encode(signs, "utf8").toUpperCase());
//            map.put("appid", ConstantUtil.APP_ID);
//            map.put("partnerid", ConstantUtil.MCH_ID);
//            map.put("timestamp", timestamp); // 等于请求prepayId时的time_start
//            map.put("noncestr", nonce_str); // 与请求prepayId时值一致
//            map.put("package", "Sign=WXPay"); // 固定常量
//            map.put("out_trade_no", orderid); // 固定常量
//            jsonObject.put("wxpay_url", map);
//        } else {
//            map.put("msg", "订单生成成功");
//            map.put("info", 404);
//        }
//        return jsonObject;
//    }
//
//    /**
//     * 接收微信支付成功通知
//     *
//     * @param request
//     * @param response
//     * @throws IOException
//     */
//    @RequestMapping(value = "getnotify")
//    @ResponseBody
//    public JSONObject getnotify(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        JSONObject jsonObject = new JSONObject();
//        System.out.println("微信支付回调");
//        PrintWriter writer = response.getWriter();
//        InputStream inStream = request.getInputStream();
//        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
//        byte[] buffer = new byte[1024];
//        int len = 0;
//        while ((len = inStream.read(buffer)) != -1) {
//            outSteam.write(buffer, 0, len);
//        }
//        outSteam.close();
//        inStream.close();
//        String result = new String(outSteam.toByteArray(), "utf-8");
//        System.out.println("微信支付通知结果：" + result);
//        Map<String, String> map = null;
//        try {
//            /**
//             * 解析微信通知返回的信息
//             */
//            map = XMLUtil.doXMLParse(result);
//        } catch (JDOMException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        System.out.println("=========:" + result);
//        // 若支付成功，则告知微信服务器收到通知
//        if (map.get("return_code").equals("SUCCESS")) {
//            System.out.println("充值成功！");
//            // 支付成功修改订单状态
//            List<ShopOrderFormMap> shopOrderFormMapList = shopOrderMapper.findByAttribute("orderId", map.get("out_trade_no").toString(),
//                    ShopOrderFormMap.class);
//            if (("0").equals(shopOrderFormMapList.get(0).get("orderState").toString())) {
//                DateUtils dateUtils = new DateUtils();
//                for (ShopOrderFormMap shopOrderFormMap : shopOrderFormMapList) {
//                    try {
//                        shopOrderFormMap.set("orderState", "1");
//                        shopOrderFormMap.set("payType", 0);
//                        shopOrderFormMap.set("tradeNo", map.get("transaction_id"));
//                        shopOrderFormMap.set("payTime", DateUtils.dateToStrLong(dateUtils.getNow()));
//                        shopOrderMapper.editEntity(shopOrderFormMap);
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                        jsonObject.put("info", 404);
//                    }
//                }
//                // 推送
//                try{
//                SellInfoFormMap sellInfoFormMap = sellInfoMapper.findbyFrist("id", shopOrderFormMapList.get(0).get("sellInfoId").toString(),
//                        SellInfoFormMap.class);
//                MerchantAccoutFormMap merchantAccoutFormMap = merchantAccountMapper.findbyFrist("id", sellInfoFormMap.get("merchantAccountId")
//                        .toString(), MerchantAccoutFormMap.class);
//                if (merchantAccoutFormMap.get("registrationId")!=null&&!("").equals(merchantAccoutFormMap.get("registrationId").toString())){
//                    JpushController jpushController = new JpushController();
//                    SellInfoFormMap sell = new SellInfoFormMap();
//                    sell.set("registrationId", merchantAccoutFormMap.get("registrationId"));
//                    sell.set("notification_title", "有新用户下单");
//                    sell.set("msg_title", "您有新的订单，请查看！");
//                    sell.set("msg_content", "您有新的订单，请查看！");
//                    jsonObject.put("out_trade_no", map.get("out_trade_no"));
//                    jsonObject.put("orderStatus", 1);
//                    sell.set("extrasparam", jsonObject.toString());
//                    jpushController.sendToShopRegistrationId(sell);
//                }
//                }catch (Exception e){
//                    jsonObject.put("info", 100);
//                }
//            }
//            jsonObject.put("info", 100);
//        }
//        return jsonObject;
//    }
//
//    /**
//     * 微信公众号申请退款
//     * <p>
//     * <p>
//     * 订单id
//     * 退款金额
//     *
//     * @param response
//     * @return
//     * @throws JsonProcessingException
//     * @throws Exception
//     */
//    @RequestMapping(value = "wxRefund")
//    @ResponseBody
//    public JSONObject wxRefund(@RequestBody ShopOrderFormMap shopOrderFormMap, HttpServletRequest request, HttpServletResponse response,
//                               ShopOrderMapper shopOrderMapper) throws JsonProcessingException {
//        /*-----  1.生成预支付订单需要的的package数据-----*/
//        // 获取生成预支付订单的请求类
//        JSONObject jsonObject = new JSONObject();
//        try {
//            String orderId = shopOrderFormMap.get("orderId").toString();
//            String totalFee = shopOrderFormMap.get("settlePrice").toString();
//            String refundFee = shopOrderFormMap.get("settlePrice").toString();
//            int total_fee1 = (int) (Float.valueOf(totalFee) * 100);
//            int refund_fee = (int) (Float.valueOf(refundFee) * 100);
//            PrepayIdRequestHandler prepayReqHandler = new PrepayIdRequestHandler(request, response);
//            String filePath=null;
////            try{
//                 filePath = "/usr/soft/cert/apiclient_cert.p12";
////            }catch (FileNotFoundException f){
////                 filePath = "E:\\apiclient_cert.p12";
////            }
//
//            // 退款需要提供证书数据，所以需要根据证书路径读取证书
////			 String filePath =
////			 "C://Users//Admin//Desktop//apiclient_cert.p12";
//            //		String filePath = "E:\\apiclient_cert.p12";
//
//            prepayReqHandler.setParameter("appid", ConstantUtil.APP_ID);
//            prepayReqHandler.setParameter("mch_id", ConstantUtil.MCH_ID);
//            String nonce_str = WXUtil.getNonceStr();
//            prepayReqHandler.setParameter("nonce_str", nonce_str);
//            prepayReqHandler.setParameter("out_trade_no", orderId);
//            out_refund_no = String.valueOf(UUID.next());
//            prepayReqHandler.setParameter("out_refund_no", out_refund_no);
//            prepayReqHandler.setParameter("total_fee", String.valueOf(total_fee1));
//            prepayReqHandler.setParameter("refund_fee", String.valueOf(refund_fee));
//            prepayReqHandler.setParameter("op_user_id", ConstantUtil.MCH_ID);
//            String sign = prepayReqHandler.createMD5Sign();
//
//            System.out.println(prepayReqHandler.createMD5Sign());
//
//            /*----3.拼装需要提交到微信的数据xml---- */
//            String xml = "<xml>" + "<appid>" + ConstantUtil.APP_ID + "</appid>" + "<mch_id>" + ConstantUtil.MCH_ID + "</mch_id>" + "<nonce_str>"
//                    + nonce_str + "</nonce_str>" + "<out_trade_no>" + orderId + "</out_trade_no>" + "<out_refund_no>" + out_refund_no
//                    + "</out_refund_no>" + "<refund_fee>" + String.valueOf(refund_fee) + "</refund_fee>" + "<total_fee>" + String.valueOf(total_fee1)
//                    + "</total_fee>" + "<op_user_id>" + ConstantUtil.MCH_ID + "</op_user_id>" + "<sign>" + sign + "</sign>" + "</xml>";
//
//            System.out.println(xml);
//
//            /*----4.读取证书文件,这一段是直接从微信支付平台提供的demo中copy的，所以一般不需要修改---- */
//            KeyStore keyStore = KeyStore.getInstance("PKCS12");
//            // FileInputStream instream = new FileInputStream(new
//            // File(filePath));
//            FileInputStream instream = new FileInputStream(filePath);
//            try {
//                keyStore.load(instream, ConstantUtil.MCH_ID.toCharArray());
//            } finally {
//                instream.close();
//            }
//            // Trust own CA and all self-signed certs
//            SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, ConstantUtil.MCH_ID.toCharArray()).build();
//            // Allow TLSv1 protocol only
//            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null,
//                    SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
//            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
//
//            /*----5.发送数据到微信的退款接口---- */
//            String url = "https://api.mch.weixin.qq.com/secapi/pay/refund";
//            HttpPost httpost = new HttpPost(url);
//            httpost.setEntity(new StringEntity(xml, "UTF-8"));
//            HttpResponse weixinResponse = httpClient.execute(httpost);
//            String jsonStr = EntityUtils.toString(weixinResponse.getEntity(), "UTF-8");
//            Map<String, String> map = XMLUtil.doXMLParse(jsonStr);
//            System.out.println(map);
//            if ("success".equalsIgnoreCase((String) map.get("return_code"))) {
//                // 退款成功修改订单状态
//                List<ShopOrderFormMap> shopOrderFormMapList = shopOrderMapper.findByAttribute("orderId", shopOrderFormMap.get("orderId").toString(),
//                        ShopOrderFormMap.class);
//                for (ShopOrderFormMap shopOrderMap : shopOrderFormMapList) {
//                    try {
//                        shopOrderMap.set("orderState", "12");
//                        shopOrderMapper.editEntity(shopOrderMap);
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                        jsonObject.put("info", 404);
//                    }
//                }
//                UserAccountFormMap userAccountFormMap = userAccountMapper.findbyFrist("id", shopOrderFormMapList.get(0).get("userAccountId")
//                        .toString(), UserAccountFormMap.class);
//                JpushController jpushController = new JpushController();
//                userAccountFormMap.set("registrationId", userAccountFormMap.get("registrationId").toString());
//                userAccountFormMap.set("notification_title", "退款成功");
//                userAccountFormMap.set("msg_title", "退款成功");
//                userAccountFormMap.set("msg_content", "退款成功");
//                userAccountFormMap.set("extrasparam", orderId);
//                jpushController.sendToUserRegistrationId(userAccountFormMap);
//
//                jsonObject.put("info", 100);
//                jsonObject.put("msg", "退款成功");
//            } else {
//                jsonObject.put("msg", "退款失败");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            jsonObject.put("info", 404);
//            jsonObject.put("msg", "退款失败");
//        }
//        return jsonObject;
//    }
//}