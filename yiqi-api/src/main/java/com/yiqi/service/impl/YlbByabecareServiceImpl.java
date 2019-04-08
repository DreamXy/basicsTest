package com.yiqi.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.common.utils.Query;

import com.yiqi.dao.YlbByabecareDao;
import com.yiqi.entity.YlbByabecareEntity;
import com.yiqi.service.YlbByabecareService;


@Service("ylbByabecareService")
public class YlbByabecareServiceImpl extends ServiceImpl<YlbByabecareDao, YlbByabecareEntity> implements YlbByabecareService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YlbByabecareEntity> page = this.selectPage(
                new Query<YlbByabecareEntity>(params).getPage(),
                new EntityWrapper<YlbByabecareEntity>()
        ); 

        return new PageUtils(page);
    }

}
