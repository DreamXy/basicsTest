package com.yiqi.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.common.utils.Query;

import com.yiqi.modules.sys.dao.YlbProductsDao;
import com.yiqi.modules.sys.entity.YlbProductsEntity;
import com.yiqi.modules.sys.service.YlbProductsService;


@Service("ylbProductsService")
public class YlbProductsServiceImpl extends ServiceImpl<YlbProductsDao, YlbProductsEntity> implements YlbProductsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YlbProductsEntity> page = this.selectPage(
                new Query<YlbProductsEntity>(params).getPage(),
                new EntityWrapper<YlbProductsEntity>()
        );

        return new PageUtils(page);
    }

}
