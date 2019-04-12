package com.yiqi.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.common.utils.Query;

import com.yiqi.dao.YlbHugongDao;
import com.yiqi.entity.YlbAccountEntity;
import com.yiqi.entity.YlbHugongEntity;
import com.yiqi.service.YlbHugongService;


@Service("ylbHugongService")
public class YlbHugongServiceImpl extends ServiceImpl<YlbHugongDao, YlbHugongEntity> implements YlbHugongService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YlbHugongEntity> page = this.selectPage(
                new Query<YlbHugongEntity>(params).getPage(),
                new EntityWrapper<YlbHugongEntity>()
        );

        return new PageUtils(page);
    }
    

	@Override
	public int add(YlbHugongEntity ye)
	{
		return this.baseMapper.add(ye);
	}

}
 