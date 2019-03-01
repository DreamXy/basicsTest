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
@TableName("ylb_department")
public class YlbDepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer hospitalid;
	/**
	 * 
	 */
	private String ylbDepartmentcol;

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
	public void setHospitalid(Integer hospitalid) {
		this.hospitalid = hospitalid;
	}
	/**
	 * 获取：
	 */
	public Integer getHospitalid() {
		return hospitalid;
	}
	/**
	 * 设置：
	 */
	public void setYlbDepartmentcol(String ylbDepartmentcol) {
		this.ylbDepartmentcol = ylbDepartmentcol;
	}
	/**
	 * 获取：
	 */
	public String getYlbDepartmentcol() {
		return ylbDepartmentcol;
	}
}
