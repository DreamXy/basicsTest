package com.yiqi.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.modules.sys.entity.YlbAdvertisingEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-25 20:51:30
 */
public interface YlbAdvertisingService extends IService<YlbAdvertisingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

