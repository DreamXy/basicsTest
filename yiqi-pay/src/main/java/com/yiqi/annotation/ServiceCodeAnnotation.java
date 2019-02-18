package com.yiqi.annotation;



import com.yiqi.enums.PayChannel;
import com.yiqi.enums.ServiceCode;

import java.lang.annotation.*;

/**
 * @author Kuang ziyang
 * @Description: 服务路由地址注解
 * @date 2018/10/3 0003 18:07
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceCodeAnnotation {

    ServiceCode[] value();
    PayChannel channel() default PayChannel.ALIPAY;
}
