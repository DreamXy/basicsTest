package com.yiqi.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.common.utils.Query;

import com.yiqi.modules.sys.dao.SysAdvertisingImgDao;
import com.yiqi.modules.sys.entity.SysAdvertisingImgEntity;
import com.yiqi.modules.sys.service.SysAdvertisingImgService;


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
