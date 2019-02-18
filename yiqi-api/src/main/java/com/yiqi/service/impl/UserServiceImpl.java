
package com.yiqi.service.impl;


import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yiqi.common.exception.RRException;
import com.yiqi.common.utils.CodeMsg;
import com.yiqi.common.validator.Assert;
import com.yiqi.dao.UserDao;
import com.yiqi.entity.TokenEntity;
import com.yiqi.entity.UserEntity;
import com.yiqi.form.LoginForm;
import com.yiqi.service.TokenService;
import com.yiqi.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
	@Autowired
	private TokenService tokenService;

	@Override
	public UserEntity queryByMobile(String mobile) {
		UserEntity userEntity = new UserEntity();
		userEntity.setMobile(mobile);
		return baseMapper.selectOne(userEntity);
	}

	@Override
	public UserEntity login(LoginForm form) {
		UserEntity user = queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new RRException(CodeMsg.ERROR, "手机号或密码错误");
		}

		//获取登录token
		TokenEntity tokenEntity = tokenService.createToken(user.getUserId());
		user.setToken(tokenEntity.getToken());

		return user;
	}

	/**
	 * 批量新增
	 * @param list
	 * @return
	 */
	@Override
	public int insertDataByBatch(List<UserEntity> list) {

		return this.baseMapper.insertDataByBatch(list);
	}

	/**
	 * 分页查询，倒序
	 *
	 * @param page
	 * @return
	 */
	@Override
	public List<UserEntity> selectUserInfoPage(Pagination page, String password) {

		return this.baseMapper.selectUserInfoPage(page, password);
	}
}
