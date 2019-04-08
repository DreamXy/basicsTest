package com.yiqi.dao;

import com.yiqi.entity.YlbAccountEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-08 21:13:57
 */
public interface YlbAccountDao extends BaseMapper<YlbAccountEntity> {

    int add(YlbAccountEntity ye);
}
