package com.yiqi.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-16 17:00:47
 */
@TableName("ylb_hospital")
public class YlbHospitalEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String hName;
	/**
	 * 
	 */
	private String hPhone;
	/**
	 * 
	 */
	private String hAddress;
	/**
	 * 
	 */
	private String hType;
	/**
	 * 
	 */
	private String hImagsrc;
	/**
	 * 
	 */
	private String hIntroduce;
	/**
	 * 
	 */
	private String hCharacteristic;
	/**
	 * 
	 */
	private String hDepartment;

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
	public void setHName(String hName) {
		this.hName = hName;
	}
	/**
	 * 获取：
	 */
	public String getHName() {
		return hName;
	}
	/**
	 * 设置：
	 */
	public void setHPhone(String hPhone) {
		this.hPhone = hPhone;
	}
	/**
	 * 获取：
	 */
	public String getHPhone() {
		return hPhone;
	}
	/**
	 * 设置：
	 */
	public void setHAddress(String hAddress) {
		this.hAddress = hAddress;
	}
	/**
	 * 获取：
	 */
	public String getHAddress() {
		return hAddress;
	}
	/**
	 * 设置：
	 */
	public void setHType(String hType) {
		this.hType = hType;
	}
	/**
	 * 获取：
	 */
	public String getHType() {
		return hType;
	}
	/**
	 * 设置：
	 */
	public void setHImagsrc(String hImagsrc) {
		this.hImagsrc = hImagsrc;
	}
	/**
	 * 获取：
	 */
	public String getHImagsrc() {
		return hImagsrc;
	}
	/**
	 * 设置：
	 */
	public void setHIntroduce(String hIntroduce) {
		this.hIntroduce = hIntroduce;
	}
	/**
	 * 获取：
	 */
	public String getHIntroduce() {
		return hIntroduce;
	}
	/**
	 * 设置：
	 */
	public void setHCharacteristic(String hCharacteristic) {
		this.hCharacteristic = hCharacteristic;
	}
	/**
	 * 获取：
	 */
	public String getHCharacteristic() {
		return hCharacteristic;
	}
	/**
	 * 设置：
	 */
	public void setHDepartment(String hDepartment) {
		this.hDepartment = hDepartment;
	}
	/**
	 * 获取：
	 */
	public String getHDepartment() {
		return hDepartment;
	}
}
