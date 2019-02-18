package com.yiqi.config;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author chan
 * @Description: mybatis plus 填充器
 * @email chan150@163.com
 * @date 2019/1/31 17:05
 */
@Component
public class MetaObjectHandlerConfig extends MetaObjectHandler {

    @Override
    public void insertFill(final MetaObject metaObject) {
        final Object createTime = getFieldValByName("create_time", metaObject);
        final Object updateTime = getFieldValByName("update_time", metaObject);

        if (StringUtils.isEmpty(createTime)){
            metaObject.setValue("createTime", new Date());
        }
        if (StringUtils.isEmpty(updateTime)){
            metaObject.setValue("updateTime", new Date());
        }
    }

    @Override
    public void updateFill(final MetaObject metaObject) {
        final Object updateTime = getFieldValByName("update_time", metaObject);

        if (StringUtils.isEmpty(updateTime)){
            metaObject.setValue("updateTime", new Date());
        }
    }

}
