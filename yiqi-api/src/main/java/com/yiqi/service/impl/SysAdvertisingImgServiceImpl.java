package com.yiqi.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.common.utils.Query;

import com.yiqi.dao.SysAdvertisingImgDao;
import com.yiqi.entity.SysAdvertisingImgEntity;
import com.yiqi.service.SysAdvertisingImgService;


@Service("sysAdvertisingImgService")
public class SysAdvertisingImgServiceImpl extends ServiceImpl<SysAdvertisingImgDao, SysAdvertisingImgEntity> implements SysAdvertisingImgService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysAdvertisingImgEntity> page = this.selectPage(
                new Query<SysAdvertisingImgEntity>(params).getPage(),
                new EntityWrapper<SysAdvertisingImgEntity>()
        );

        return new PageUtils(page);
    }

}
