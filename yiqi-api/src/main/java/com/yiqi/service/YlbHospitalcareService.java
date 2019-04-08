package com.yiqi.service;

import com.baomidou.mybatisplus.service.IService;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.entity.YlbHospitalcareEntity;

import java.util.Map;

/**
 * 医院陪护
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-07 23:07:37
 */
public interface YlbHospitalcareService extends IService<YlbHospitalcareEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

