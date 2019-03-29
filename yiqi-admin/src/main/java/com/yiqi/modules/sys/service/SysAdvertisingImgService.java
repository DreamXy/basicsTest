package com.yiqi.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.modules.sys.entity.SysAdvertisingImgEntity;
import com.yiqi.modules.sys.entity.SysUserEntity;

import java.util.List;
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
    
	
	/**
	 * 保存用户
	 */
	void save(SysAdvertisingImgEntity user);
	
	/**
	 * 修改用户
	 */
	void update(SysAdvertisingImgEntity user);

}

