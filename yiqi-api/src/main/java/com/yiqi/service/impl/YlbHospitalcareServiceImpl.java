package com.yiqi.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.common.utils.Query;

import com.yiqi.dao.YlbHospitalcareDao;
import com.yiqi.entity.YlbHospitalcareEntity;
import com.yiqi.service.YlbHospitalcareService;


@Service("ylbHospitalcareService")
public class YlbHospitalcareServiceImpl extends ServiceImpl<YlbHospitalcareDao, YlbHospitalcareEntity> implements YlbHospitalcareService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YlbHospitalcareEntity> page = this.selectPage(
                new Query<YlbHospitalcareEntity>(params).getPage(),
                new EntityWrapper<YlbHospitalcareEntity>()
        );

        return new PageUtils(page);
    }

}
