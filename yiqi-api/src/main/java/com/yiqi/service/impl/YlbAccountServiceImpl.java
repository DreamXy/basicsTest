package com.yiqi.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.common.utils.Query;

import com.yiqi.dao.YlbAccountDao;
import com.yiqi.entity.YlbAccountEntity;
import com.yiqi.service.YlbAccountService;


@Service("ylbAccountService")
public class YlbAccountServiceImpl extends ServiceImpl<YlbAccountDao, YlbAccountEntity> implements YlbAccountService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YlbAccountEntity> page = this.selectPage(
                new Query<YlbAccountEntity>(params).getPage(),
                new EntityWrapper<YlbAccountEntity>()
        );

        return new PageUtils(page);
    }


	@Override
	public int add(YlbAccountEntity ye)
	{
		return this.baseMapper.add(ye);
	}
}
