package com.yiqi.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.modules.sys.entity.YlbProductsEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-26 00:29:42
 */
public interface YlbProductsService extends IService<YlbProductsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

