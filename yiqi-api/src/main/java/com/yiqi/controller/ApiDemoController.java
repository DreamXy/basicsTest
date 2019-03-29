package com.yiqi.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.yiqi.annotation.Login;
import com.yiqi.annotation.LoginUser;
import com.yiqi.common.exception.RRException;
import com.yiqi.common.utils.CodeMsg;
import com.yiqi.common.validator.Assert;
import com.yiqi.common.validator.ValidatorUtils;
import com.yiqi.entity.*;
import com.yiqi.form.PageForm;
import com.yiqi.form.UserForm;
import com.yiqi.interceptor.AuthorizationInterceptor;
import com.yiqi.utils.CustomerPage;
import com.yiqi.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

/**
 * @author chan
 * @Description: demo 接口
 * @email chan150@163.com
 * @date 2019-01-23 10:47
 */
@RestController
@RequestMapping("/api/Home")
@Api(tags = "demo接口")
public class ApiDemoController extends BasicController {

	@Login
	@GetMapping("userInfo1")
	@ApiOperation(value = "获取用户信息(方式一)")
	public Result<YlbAccountEntity> userInfo1(
			@ApiIgnore @RequestAttribute(AuthorizationInterceptor.USER_KEY) Long userId) {

		return Result.success(userService.selectById(userId));
	}

	@Login
	@GetMapping("userInfo2")
	@ApiOperation(value = "获取用户信息(方式二)")
	public Result<UserEntity> userInfo2(@ApiIgnore @LoginUser UserEntity user) {

		return Result.success(user);
	}

	@GetMapping("Index")
	@ApiOperation(value = "获取首页信息")
	public Result<HomeModel> Home() {
		HomeModel ms = new HomeModel();
		// 头部广告
		List<SysAdvertisingImgEntity> topAdvertisingImgEntity = sysAdvertisingImgService.selectList(new EntityWrapper<SysAdvertisingImgEntity>()
				.eq("imgtype", 0).eq("imgtype", 1).orderBy("create_date", false));
		if (topAdvertisingImgEntity == null || topAdvertisingImgEntity.isEmpty()) {
			ms.SysAdvertisingImgList = Collections.emptyList();
		} else
			ms.SysAdvertisingImgList = topAdvertisingImgEntity;
		// 广告咨询
		List<YlbAdvertisingEntity> ylbAdvertisingEntity = ylbAdvertisingService
				.selectList(new EntityWrapper<>());
		if (ylbAdvertisingEntity == null || ylbAdvertisingEntity.isEmpty()) {
			ms.setYlbAdvertisingList(Collections.emptyList());
		} else
			ms.setYlbAdvertisingList(ylbAdvertisingEntity);
		// 金牌护工
		List<YlbHugongEntity> HugongList = ylbHugongService.selectList(new EntityWrapper<>());
		if (HugongList == null || HugongList.isEmpty()) {
			ms.YlbHugongList = Collections.emptyList();
		} else
			ms.YlbHugongList = HugongList;
		// 底部广告
		// 商品 YlbProductsService
		List<YlbProductsEntity> ProductsList = ylbProductsService.selectList(new EntityWrapper<>());
		if (ProductsList == null || ProductsList.isEmpty()) {
			ms.YlbProductsList = Collections.emptyList();
		} else
			ms.YlbProductsList = ProductsList;
		
		return Result.success(ms);
	}

	@GetMapping("selectAllUserInfo")
	@ApiOperation(value = "获取所有用户信息")
	public Result<List<YlbAccountEntity>> userInfo() {

		List<YlbAccountEntity> userEntityList = userService.selectList(new EntityWrapper<>());
		if (userEntityList == null || userEntityList.isEmpty()) {
			return Result.error(CodeMsg.NOT_FIND_DATA, Collections.emptyList());
		}
		return Result.success(userEntityList);
	}

	@GetMapping("selectUserInfoById/{id}")
	@ApiOperation(value = "由id获取用户信息")
	public Result<YlbAccountEntity> selectUserInfoById(@PathVariable("id") Long id) {

		return Result.success(userService.selectById(id));
	}

	@GetMapping("selectUserInfoByCondition1")
	@ApiOperation(value = "条件查询用户信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "query"),
			@ApiImplicitParam(name = "username", value = "用户名", paramType = "query") })
	public Result<List<YlbAccountEntity>> selectUserInfoByCondition1(String mobile, String username) {
		HashMap<String, Object> map = new HashMap<>(2);
		map.put("mobile", mobile);
		map.put("username", username);

		List<YlbAccountEntity> userEntityList = userService.selectByMap(map);
		if (userEntityList == null || userEntityList.isEmpty()) {
			return Result.error(CodeMsg.NOT_FIND_DATA, Collections.emptyList());
		}
		return Result.success(userEntityList);
	}

	@GetMapping("selectUserInfoByCondition2")
	@ApiOperation(value = "条件查询用户信息")
	@ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query")
	public Result<List<YlbAccountEntity>> selectUserInfoByCondition2(String password) {

		/** 条件查询，并进行倒序 **/

		List<YlbAccountEntity> userEntityList = userService.selectList(new EntityWrapper<YlbAccountEntity>()
				.eq("password", DigestUtils.sha256Hex(password)).orderBy("create_time", false));

		if (CollectionUtils.isEmpty(userEntityList)) {
			return Result.error(CodeMsg.NOT_FIND_DATA, Collections.emptyList());
		}
		return Result.success(userEntityList);
	}

//    @GetMapping("selectUserInfoPage1")
//    @ApiOperation(value="分页查询用户信息")
//    @ApiImplicitParam(name = "password",value = "密码",required = true,paramType="query")
//    public Result<CustomerPage<UserEntity>> selectUserInfoPage1(PageForm form, String password) {
//        ValidatorUtils.validateEntity(form);
//
//        Page<UserEntity> userEntityPage = new Page<>(form.getPage(), form.getLimit());
//        userEntityPage = userService.selectPage(userEntityPage, new EntityWrapper<UserEntity>().eq("password", DigestUtils.sha256Hex(password)));
//
//        return Result.success(new CustomerPage(userEntityPage));
//    }

//    @GetMapping("selectUserInfoPage2")
//    @ApiOperation(value="自定义sql，分页查询用户信息")
//    @ApiImplicitParam(name = "password",value = "密码",required = true,paramType="query")
//    public Result<CustomerPage<UserEntity>> selectUserInfoPage2(PageForm form, String password) {
//        Assert.isBlank(password, CodeMsg.PARAMETER_ISNULL);
//
//        Page<UserEntity> userEntityPage = new Page<>(form.getPage(), form.getLimit());
//        userEntityPage.setRecords(userService.selectUserInfoPage(userEntityPage, DigestUtils.sha256Hex(password)));
//
//        return Result.success(new CustomerPage(userEntityPage));
//    }
//
//    @GetMapping("saveUser")
//    @ApiOperation(value="新增用户")
//    public Result saveUser(UserForm form) {
//        ValidatorUtils.validateEntity(form);
//
//        UserEntity user = new UserEntity();
//        BeanUtils.copyProperties(form, user);
//        user.setAccountPwd(DigestUtils.sha256Hex(form.getPassword()));
//        boolean flag = userService.insert(user);
//
//        if(flag) {
//            return Result.success();
//        }
//        return Result.error(CodeMsg.ERROR);
//    }
//
//    @GetMapping("insertBatchUser")
//    @ApiOperation(value="批量新增用户")
//    public Result insertBatchUser(@RequestBody List<UserEntity> list) {
//
//        /**
//         * mybatis plus 自带insertBatch方法不建议使用，属于 伪批量
//         * 建议自行写sql，如下方法 insertDataByBatch
//         */
//        int result = userService.insertDataByBatch(list);
//        if(result > 0) {
//            return Result.success();
//        }
//        return Result.error(CodeMsg.ERROR);
//    }
//
//    @GetMapping("deleteBatchUser/{ids}")
//    @ApiOperation(value="批量删除用户")
//    @ApiImplicitParam(name = "ids",value = "用户ID字符串(例如：12,13[逗号是英文])",required = true,dataType = "String",paramType="path")
//    public Result deleteBatchUser(@PathVariable("ids") String ids) {
//        // 数据校验
//        Assert.isBlank(ids, CodeMsg.NOT_FIND_DATA);
//
//        StringTokenizer st = new StringTokenizer(ids, ",");
//        List<String> idList = new ArrayList<>();
//        while(st.hasMoreTokens()) {
//            idList.add(st.nextToken());
//        }
//        boolean result = userService.deleteBatchIds(idList);
//        if(result) {
//            return Result.success();
//        }
//        return Result.error(CodeMsg.ERROR);
//    }
//
//    @PostMapping("updateBatchUser")
//    @ApiOperation(value="批量更新用户")
//    public Result updateBatchUser() {
//        Long[] ids = {new Long(1), new Long(43)};
//        List<UserEntity> list = userService.selectList(new EntityWrapper<UserEntity>().in("user_id", ids));
//        UserEntity user1 = list.get(0);
//        user1.setAccountPwd("aba");
//        UserEntity user2 = list.get(1);
//        user2.setAccoutnName("hdfh");
//
//        boolean boo = userService.updateBatchById(list);
//        if(boo) {
//            return Result.success();
//        }
//        return Result.error(CodeMsg.ERROR);
//    }
//
//    @PostMapping("selectBatchUser/{ids}")
//    @ApiOperation(value="批量查询用户")
//    @ApiImplicitParam(name = "ids",value = "用户ID字符串(例如：12,13[逗号是英文])",required = true,dataType = "String",paramType="path")
//    public Result<List<UserEntity>> selectBatchUser(@PathVariable("ids") String ids) {
//
//        StringTokenizer st = new StringTokenizer(ids, ",");
//        List<String> idList = new ArrayList<>();
//        while(st.hasMoreTokens()) {
//            idList.add(st.nextToken());
//        }
//
//        List<UserEntity> list = userService.selectList(new EntityWrapper<UserEntity>().in("user_id", ids));
//        return Result.success(list);
//    }
//
//    @Login
//    @GetMapping("updateUser")
//    @ApiOperation(value="更新用户信息")
//    @Transactional(rollbackFor = Exception.class)
//    public Result updateUser(@ApiIgnore @LoginUser UserEntity user) {
//        user.setAccoutnName("123");
//
//        try {
//            boolean boo = userService.updateById(user);
//            if(boo) {
//                return Result.success();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOGGER.error("更新失败");
//            throw new RRException("更新失败");
//        }
//        return Result.error(CodeMsg.ERROR);
//    }
//
//    @GetMapping("testUserPage")
//    @ApiOperation(value="测试分页用户信息")
//    public Result<CustomerPage<UserEntity>> testUserPage() {
//
//        Page<UserEntity> page = userService.selectPage(new Page<>(1, 10, "create_time", false));
//        return Result.success(new CustomerPage<UserEntity>(page));
//    }

}
