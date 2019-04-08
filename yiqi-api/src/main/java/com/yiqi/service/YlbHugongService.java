package com.yiqi.service;

import com.baomidou.mybatisplus.service.IService;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.entity.YlbHugongEntity;

import java.util.Map;

/**
 * 护工
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-07 23:07:37
 */
public interface YlbHugongService extends IService<YlbHugongEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

 