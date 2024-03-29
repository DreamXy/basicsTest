
package com.yiqi.service.impl;


import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yiqi.common.exception.RRException;
import com.yiqi.common.utils.CodeMsg;
import com.yiqi.common.validator.Assert;
import com.yiqi.dao.UserDao;
import com.yiqi.entity.*;
import com.yiqi.form.LoginForm;
import com.yiqi.service.TokenService;
import com.yiqi.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, YlbAccountEntity> implements UserService {
	@Autowired
	private TokenService tokenService;

	@Override
	public YlbAccountEntity queryByMobile(String mobile) {
		YlbAccountEntity userEntity = new YlbAccountEntity();
		userEntity.setAccountphone(mobile);
		return baseMapper.selectOne(userEntity);
	}

	@Override
	public YlbAccountEntity login(LoginForm form) {
		YlbAccountEntity user = queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getAccountpwd().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new RRException(CodeMsg.ERROR, "手机号或密码错误");
		}

		//获取登录token
		TokenEntity tokenEntity = tokenService.createToken(user.getAccountid());
//		user.setToken(tokenEntity.getToken());

		return user;
	}

	/**
	 * 批量新增
	 * @param list
	 * @return
	 */
	@Override
	public int insertDataByBatch(List<YlbAccountEntity> list) {

		return this.baseMapper.insertDataByBatch(list);
	}

	/**
	 * 分页查询，倒序
	 *
	 * @param page
	 * @return
	 */
	@Override
	public List<YlbAccountEntity> selectUserInfoPage(Pagination page, String password) {

		return this.baseMapper.selectUserInfoPage(page, password);
	}

	@Override
	public int add(YlbAccountEntity ye)
	{
		return this.baseMapper.add(ye);
	}
}
