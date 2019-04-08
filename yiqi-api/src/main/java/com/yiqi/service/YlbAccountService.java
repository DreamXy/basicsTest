package com.yiqi.service;

import com.baomidou.mybatisplus.service.IService;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.entity.YlbAccountEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-08 21:13:57
 */
public interface YlbAccountService extends IService<YlbAccountEntity> {

    PageUtils queryPage(Map<String, Object> params);

	  int add(YlbAccountEntity ye);
}

