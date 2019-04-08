package com.yiqi.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 护工
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-07 23:07:37
 */
@TableName("ylb_hugong")
public class YlbHugongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String photo;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 工作状态 、忙、闲
	 */
	private String workstate;
	/**
	 * 护工服务类型 1为 医院陪护 2为家庭陪护 3为母婴 4为管理员
	 */
	private String servetyle;
	/**
	 * 身份证
	 */
	private String idcard;
	/**
	 * 
	 */
	private Integer ismanageteacher;
	
	private Integer accountid;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/**
	 * 获取：
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * 设置：年龄
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 获取：年龄
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：工作状态 、忙、闲
	 */
	public void setWorkstate(String workstate) {
		this.workstate = workstate;
	}
	/**
	 * 获取：工作状态 、忙、闲
	 */
	public String getWorkstate() {
		return workstate;
	}
	/**
	 * 设置：护工服务类型 1为 医院陪护 2为家庭陪护 3为母婴 4为管理员
	 */
	public void setServetyle(String servetyle) {
		this.servetyle = servetyle;
	}
	/**
	 * 获取：护工服务类型 1为 医院陪护 2为家庭陪护 3为母婴 4为管理员
	 */
	public String getServetyle() {
		return servetyle;
	}
	/**
	 * 设置：身份证
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	/**
	 * 获取：身份证
	 */
	public String getIdcard() {
		return idcard;
	}
	/**
	 * 设置：
	 */
	public void setIsmanageteacher(Integer ismanageteacher) {
		this.ismanageteacher = ismanageteacher;
	}
	/**
	 * 获取：
	 */
	public Integer getIsmanageteacher() {
		return ismanageteacher;
	}
	public Integer getAccountid() {
		return accountid;
	}
	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}
	
	
}
