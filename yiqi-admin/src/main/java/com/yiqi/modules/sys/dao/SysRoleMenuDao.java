
package com.yiqi.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yiqi.modules.sys.entity.SysRoleMenuEntity;

import java.util.List;

/**
 * 角色与菜单对应关系
 * 
 * @author chenshun
 *
 * @date 2016年9月18日 上午9:33:46
 */
public interface SysRoleMenuDao extends BaseMapper<SysRoleMenuEntity> {
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);
}
