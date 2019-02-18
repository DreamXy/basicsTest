package com.yiqi.service.alipay;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayFundTransToaccountTransferModel;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.yiqi.annotation.ServiceCodeAnnotation;
import com.yiqi.common.utils.R;
import com.yiqi.config.common.AlipayConfig;
import com.yiqi.enums.PayChannel;
import com.yiqi.enums.ServiceCode;
import com.yiqi.payEntity.PayBaseEntity;
import com.yiqi.payEntity.PayTransferEntity;
import com.yiqi.service.AliBasePayService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Kuang ziyang
 * @Description: 阿里转账服务
 * @date 2018/10/3 0003 14:56
 */
@Service
@ServiceCodeAnnotation(value = {ServiceCode.ALI_FUND_TRANS_TO_ACCOUNT_TRANSFER, ServiceCode.TRANSFER_SERVER}, channel = PayChannel.ALIPAY)
public class AliFundTransToAccountTransferPayService extends AliBasePayService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public R execute(PayBaseEntity entity) throws Exception {

        PayTransferEntity data = (PayTransferEntity)entity;
        String transactionMount = data.getTransactionMount();//转账金额
        String payeeAccount = data.getPayeeAccount();        //支付宝账号
        String realName = data.getRealName();                //支付宝姓名
        String commissionUid = data.getCommissionUid();      //交易订单号
        String payeeRealName = data.getPayeeRealName();      //付款方姓名
        String remark = data.getRemark();                    //备注

        if (StringUtils.isEmpty(payeeAccount)) {
            return R.error(10001, "支付宝账号为空").put("data", "");
        }

        AlipayClient alipayClient_transfer = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET2, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);
        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
        AlipayFundTransToaccountTransferModel model = new AlipayFundTransToaccountTransferModel();

        /**
         * 收款方账户类型。可取值：(必选)
         * 1、ALIPAY_USERID：支付宝账号对应的支付宝唯一用户号。以2088开头的16位纯数字组成。
         * 2、ALIPAY_LOGONID：支付宝登录号，支持邮箱和手机号格式。
         */
        model.setPayeeType("ALIPAY_LOGONID");
        /**
         * (可选)
         * 转账备注（支持200个英文/100个汉字）。
         * 当付款方为企业账户，且转账金额达到（大于等于）50000元，remark不能为空
         */
        model.setRemark(remark);
        model.setOutBizNo(commissionUid);   //商户转账唯一订单号(必选)
        model.setPayeeAccount(payeeAccount);//收款方账户（必选）
        model.setAmount(transactionMount);  // 转账金额，单位：元。
        model.setPayerShowName(payeeRealName);  //付款方姓名（可选）
        model.setPayeeRealName(realName);   //收款方真实姓名（可选）
        request.setBizModel(model);

        AlipayFundTransToaccountTransferResponse response = alipayClient_transfer.execute(request);
        String responseCode = response.getCode();
        String commissionUid_from_response = response.getOutBizNo();

        if ("10000".equals(responseCode)) {
            log.error("阿里转账服务调用成功：回传订单号["+commissionUid+"]，responseCode["+responseCode+"]");
            return R.ok("提现成功").put("outBizNo",commissionUid_from_response);
        } else {
            log.error("阿里转账服务调用失败：回传订单号["+commissionUid+"]，responseCode["+responseCode+"]。错误信息：" + response.getSubMsg());
            return R.error(40004,response.getSubMsg());
        }

    }

    @Override
    public R callBack() {
        return null;
    }

}
