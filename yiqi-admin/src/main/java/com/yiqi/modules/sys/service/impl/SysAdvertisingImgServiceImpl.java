package com.yiqi.modules.sys.service.impl;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.common.utils.Query;

import com.yiqi.modules.sys.dao.SysAdvertisingImgDao;
import com.yiqi.modules.sys.entity.SysAdvertisingImgEntity;
import com.yiqi.modules.sys.entity.SysUserEntity;
import com.yiqi.modules.sys.service.SysAdvertisingImgService;
import com.yiqi.modules.sys.shiro.ShiroUtils;


@Service("sysAdvertisingImgService")
public class SysAdvertisingImgServiceImpl extends ServiceImpl<SysAdvertisingImgDao, SysAdvertisingImgEntity> implements SysAdvertisingImgService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysAdvertisingImgEntity> page = this.selectPage(
                new Query<SysAdvertisingImgEntity>(params).getPage(),
                new EntityWrapper<SysAdvertisingImgEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	@Transactional(rollbackFor = Exception.class)
	public void save(SysAdvertisingImgEntity user) {
//		user.setCreateTime(new Date());
//		//sha256加密
//		String salt = RandomStringUtils.randomAlphanumeric(20);
//		user.setSalt(salt);
//		user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));
//		this.insert(user);
//		
//		//保存用户与角色关系
//		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(SysAdvertisingImgEntity user) {
//		if(StringUtils.isBlank(user.getPassword())){
//			user.setPassword(null);
//		}else{
//			user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));
//		}
//		this.updateById(user);
//		
//		//保存用户与角色关系
//		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}



}
