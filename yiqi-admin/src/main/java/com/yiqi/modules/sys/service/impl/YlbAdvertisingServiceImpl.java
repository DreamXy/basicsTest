package com.yiqi.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.common.utils.Query;

import com.yiqi.modules.sys.dao.YlbAdvertisingDao;
import com.yiqi.modules.sys.entity.YlbAdvertisingEntity;
import com.yiqi.modules.sys.service.YlbAdvertisingService;


@Service("ylbAdvertisingService")
public class YlbAdvertisingServiceImpl extends ServiceImpl<YlbAdvertisingDao, YlbAdvertisingEntity> implements YlbAdvertisingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YlbAdvertisingEntity> page = this.selectPage(
                new Query<YlbAdvertisingEntity>(params).getPage(),
                new EntityWrapper<YlbAdvertisingEntity>()
        );

        return new PageUtils(page);
    }

}
