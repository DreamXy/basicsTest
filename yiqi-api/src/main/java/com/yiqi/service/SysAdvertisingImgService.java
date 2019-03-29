package com.yiqi.service;

import com.baomidou.mybatisplus.service.IService;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.entity.SysAdvertisingImgEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-24 13:15:08
 */
public interface SysAdvertisingImgService extends IService<SysAdvertisingImgEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

