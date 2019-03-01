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
@TableName("ylb_doctor")
public class YlbDoctorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String dName;
	/**
	 * 
	 */
	private Integer dLevel;
	/**
	 * 
	 */
	private String dImagesrc;
	/**
	 * 
	 */
	private String dDepartment;
	/**
	 * 
	 */
	private String dHospital;
	/**
	 * 
	 */
	private String dSpeciality;
	/**
	 * 
	 */
	private String dExperience;
	/**
	 * 
	 */
	private String dIntroduction;
	/**
	 * 
	 */
	private String dCertificates;

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
	public void setDName(String dName) {
		this.dName = dName;
	}
	/**
	 * 获取：
	 */
	public String getDName() {
		return dName;
	}
	/**
	 * 设置：
	 */
	public void setDLevel(Integer dLevel) {
		this.dLevel = dLevel;
	}
	/**
	 * 获取：
	 */
	public Integer getDLevel() {
		return dLevel;
	}
	/**
	 * 设置：
	 */
	public void setDImagesrc(String dImagesrc) {
		this.dImagesrc = dImagesrc;
	}
	/**
	 * 获取：
	 */
	public String getDImagesrc() {
		return dImagesrc;
	}
	/**
	 * 设置：
	 */
	public void setDDepartment(String dDepartment) {
		this.dDepartment = dDepartment;
	}
	/**
	 * 获取：
	 */
	public String getDDepartment() {
		return dDepartment;
	}
	/**
	 * 设置：
	 */
	public void setDHospital(String dHospital) {
		this.dHospital = dHospital;
	}
	/**
	 * 获取：
	 */
	public String getDHospital() {
		return dHospital;
	}
	/**
	 * 设置：
	 */
	public void setDSpeciality(String dSpeciality) {
		this.dSpeciality = dSpeciality;
	}
	/**
	 * 获取：
	 */
	public String getDSpeciality() {
		return dSpeciality;
	}
	/**
	 * 设置：
	 */
	public void setDExperience(String dExperience) {
		this.dExperience = dExperience;
	}
	/**
	 * 获取：
	 */
	public String getDExperience() {
		return dExperience;
	}
	/**
	 * 设置：
	 */
	public void setDIntroduction(String dIntroduction) {
		this.dIntroduction = dIntroduction;
	}
	/**
	 * 获取：
	 */
	public String getDIntroduction() {
		return dIntroduction;
	}
	/**
	 * 设置：
	 */
	public void setDCertificates(String dCertificates) {
		this.dCertificates = dCertificates;
	}
	/**
	 * 获取：
	 */
	public String getDCertificates() {
		return dCertificates;
	}
}
