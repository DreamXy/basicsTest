package com.yiqi.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.modules.sys.entity.SysAdvertisingImgEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-13 17:06:06
 */
public interface SysAdvertisingImgService extends IService<SysAdvertisingImgEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

