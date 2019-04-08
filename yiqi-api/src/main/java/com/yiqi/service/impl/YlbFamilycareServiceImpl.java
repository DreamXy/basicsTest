package com.yiqi.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.common.utils.Query;

import com.yiqi.dao.YlbFamilycareDao;
import com.yiqi.entity.YlbFamilycareEntity;
import com.yiqi.service.YlbFamilycareService;


@Service("ylbFamilycareService")
public class YlbFamilycareServiceImpl extends ServiceImpl<YlbFamilycareDao, YlbFamilycareEntity> implements YlbFamilycareService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YlbFamilycareEntity> page = this.selectPage(
                new Query<YlbFamilycareEntity>(params).getPage(),
                new EntityWrapper<YlbFamilycareEntity>()
        );

        return new PageUtils(page);
    }

} 
