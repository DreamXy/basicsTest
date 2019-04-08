
package com.yiqi.service;


import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.yiqi.entity.*;
import com.yiqi.form.LoginForm;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * 用户
 * 
 * @author chenshun
 *
 * @date 2017-03-23 15:22:06
 */
public interface UserService extends IService<YlbAccountEntity> {

	YlbAccountEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param form    登录表单
	 * @return        返回登录信息
	 */
	YlbAccountEntity login(LoginForm form);

	/**
	 * 批量新增
	 * @param list
	 * @return
	 */
	int insertDataByBatch(List<YlbAccountEntity> list);

	/**
	 * 分页查询，倒序
	 * @param page
	 * @return
	 */
	List<YlbAccountEntity> selectUserInfoPage(Pagination page, String password);
	
//    @Insert("insert into ylb_account(accountphone,registertime,accountsate) value(#{name},#{creditHour})")
//    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")//加入该注解可以保持对象后，查看对象插入id
//    int insertkun(YlbAccountEntity s);
	
	  int add(YlbAccountEntity ye);
	   
}
