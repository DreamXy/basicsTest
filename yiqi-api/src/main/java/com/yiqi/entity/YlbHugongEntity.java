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
 * @date 2019-03-24 13:15:08
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
	 * 
	 */
	private String leve;
	/**
	 * 
	 */
	private Integer age;
	/**
	 * 
	 */
	private Integer sex;
	/**
	 * 
	 */
	private String workage;
	/**
	 * 
	 */
	private String hospital;
	/**
	 * 
	 */
	private String workstate;
	/**
	 * 
	 */
	private String ylbHugongcol;
	/**
	 * 
	 */
	private Integer ishealth;
	/**
	 * 
	 */
	private Integer isoldage;

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
	 * 设置：
	 */
	public void setLeve(String leve) {
		this.leve = leve;
	}
	/**
	 * 获取：
	 */
	public String getLeve() {
		return leve;
	}
	/**
	 * 设置：
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 获取：
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 设置：
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：
	 */
	public void setWorkage(String workage) {
		this.workage = workage;
	}
	/**
	 * 获取：
	 */
	public String getWorkage() {
		return workage;
	}
	/**
	 * 设置：
	 */
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	/**
	 * 获取：
	 */
	public String getHospital() {
		return hospital;
	}
	/**
	 * 设置：
	 */
	public void setWorkstate(String workstate) {
		this.workstate = workstate;
	}
	/**
	 * 获取：
	 */
	public String getWorkstate() {
		return workstate;
	}
	/**
	 * 设置：
	 */
	public void setYlbHugongcol(String ylbHugongcol) {
		this.ylbHugongcol = ylbHugongcol;
	}
	/**
	 * 获取：
	 */
	public String getYlbHugongcol() {
		return ylbHugongcol;
	}
	/**
	 * 设置：
	 */
	public void setIshealth(Integer ishealth) {
		this.ishealth = ishealth;
	}
	/**
	 * 获取：
	 */
	public Integer getIshealth() {
		return ishealth;
	}
	/**
	 * 设置：
	 */
	public void setIsoldage(Integer isoldage) {
		this.isoldage = isoldage;
	}
	/**
	 * 获取：
	 */
	public Integer getIsoldage() {
		return isoldage;
	}
}
