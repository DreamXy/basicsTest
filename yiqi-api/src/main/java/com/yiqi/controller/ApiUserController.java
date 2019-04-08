package com.yiqi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.yiqi.common.utils.CodeMsg;
import com.yiqi.common.utils.R;
import com.yiqi.common.validator.ValidatorUtils;
import com.yiqi.entity.TokenEntity;
import com.yiqi.entity.YlbAccountEntity;
import com.yiqi.entity.YlbAdvertisingEntity;
import com.yiqi.entity.YlbHugongEntity;
import com.yiqi.form.HuGongForm;
import com.yiqi.form.PageForm;
import com.yiqi.form.RegisterForm;
import com.yiqi.form.UserForm;
import com.yiqi.interceptor.AuthorizationInterceptor;
import com.yiqi.service.TokenService;
import com.yiqi.service.YlbAccountService;
import com.yiqi.service.YlbByabecareService;
import com.yiqi.service.YlbFamilycareService;
import com.yiqi.service.YlbHospitalcareService;
import com.yiqi.service.YlbHugongService;
import com.yiqi.utils.CustomerPage;
import com.yiqi.utils.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author chan
 * @Description: demo 接口
 * @email chan150@163.com
 * @date 2019-01-23 10:47
 */
@RestController
@RequestMapping("/api/User")
@Api(tags = "demo接口")
public class ApiUserController extends BasicController {
	@Autowired
	private YlbAccountService userService;

	@Autowired
	private YlbHugongService ylbHugongService;

	@Autowired
	private YlbByabecareService ylbByabecareService;

	@Autowired
	private YlbFamilycareService ylbfamilycareService;

	@Autowired
	private YlbHospitalcareService ylbhospitalcareService;

	@Autowired
	private TokenService tokenService;

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	@ApiOperation(value = "账号注册")
	public R register(@RequestBody RegisterForm form) {
		ValidatorUtils.validateEntity(form);
		YlbAccountEntity yace = new YlbAccountEntity();
		yace.setAccountphone(form.getMobile());
		yace.setImagsrc(form.getImagsrc());
		yace.setAccoutnname(form.getUsername());
		yace.setAccouttype(
				form.getRegtype() == "" || form.getRegtype() == null ? 0 : Integer.parseInt(form.getRegtype()));
		switch (form.getRegtype()) {
		case "2":
			yace.setWxopenid(form.getOpenid());
			break;
		case "3":
			yace.setQqopenid(form.getOpenid());
			break;
		case "4":
			yace.setXcopenid(form.getOpenid());
			break;
		}
		yace.setRegistertime(new Date());
		yace.setAccountsate(0);
		int flag = userService.add(yace);
		System.out.println("新增返回参数"+flag+"xin"+yace.getAccountid());
		if (flag > 0) {
			// 获取登录token
			TokenEntity tokenEntity = tokenService.createToken(yace.getAccountid());

			Map<String, Object> map = new HashMap<>(2);
			map.put("token", tokenEntity.getToken());
			map.put("expire", tokenEntity.getExpireTime().getTime() - System.currentTimeMillis());
			return R.ok(map);
		}
		return R.error();
	}

	@GetMapping(path = "/GetUserId")
	public Result GetUserId(@RequestAttribute(AuthorizationInterceptor.USER_KEY) Long userId) {
		TokenEntity te = tokenService.queryByToken(userId.toString());
		return Result.success("用户ID" + userId+" 堕落的原因："+te.getToken() +" 夜晚："+te.getUserId()+" 过期："+te.getExpireTime() +" 修改"+te.getUpdateTime());
	}

	@RequestMapping(path = "/ApplyHg", method = RequestMethod.POST)
	@ApiOperation(value = "护工申请")
	public Result applyHg(@RequestBody HuGongForm form) {

		ValidatorUtils.validateEntity(form);
		YlbHugongEntity ylbhge = new YlbHugongEntity();
		ylbhge.setAge(Integer.parseInt(form.getAge()));
		ylbhge.setIdcard(form.getIdcard());
		ylbhge.setIsmanageteacher(form.getIsmanageteacher());
		ylbhge.setName(form.getName());
		ylbhge.setPhoto(form.getPhoto());
		ylbhge.setSex(Integer.parseInt(form.getSex()));

		return Result.error(CodeMsg.ERROR);
	}

}
