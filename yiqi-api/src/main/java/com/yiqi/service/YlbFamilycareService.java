package com.yiqi.service;

import com.baomidou.mybatisplus.service.IService;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.entity.YlbFamilycareEntity;

import java.util.Map;

/**
 * 家庭陪护
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-07 23:07:37
 */
public interface YlbFamilycareService extends IService<YlbFamilycareEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

