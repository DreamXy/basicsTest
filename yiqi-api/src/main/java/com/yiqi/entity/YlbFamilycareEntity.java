package com.yiqi.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 家庭陪护
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-07 23:07:37
 */
@TableName("ylb_familycare")
public class YlbFamilycareEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 所属公司名称
	 */
	private Integer hugongid;
	/**
	 * 护工级别
	 */
	private String leve;
	/**
	 * 工作年龄
	 */
	private String workage;
	/**
	 * 所属医院
	 */
	private Integer hospitalid;
	/**
	 * 是否养老证
	 */
	private Integer isoldage;
	/**
	 * 
	 */
	private String company;
	/**
	 * 所属公司名称
	 */
	private Integer companyname;
	/**
	 * 所属医院名称
	 */
	private String hospitalname;
	/**
	 * 星级数
	 */
	private Integer stars;
	/**
	 * 服务范围
	 */
	private String serverange;
	/**
	 * 服务次数
	 */
	private Integer servecounts;
	/**
	 * 好评率
	 */
	private String quality;
	/**
	 * 个人简介
	 */
	private String introductions;
	/**
	 * 是否拥有健康证
	 */
	private Integer ishealth;
	/**
	 * 审核状态0 处于未提交审核 1提交审核 审核待处理 2审核通关 3审核拒绝
	 */
	private String auditstate;
	/**
	 * 审核时间
	 */
	private Date audittime;
	/**
	 * 审核复述内容
	 */
	private String auditremark;
	/**
	 * 最后操作时间
	 */
	private Date uptime;
	/**
	 * 身份证同步主表
	 */
	private String idcard;
	/**
	 * 健康证图片
	 */
	private String healthimage;
	/**
	 * 养老陪护证
	 */
	private String oldageimage;

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
	 * 设置：所属公司名称
	 */
	public void setHugongid(Integer hugongid) {
		this.hugongid = hugongid;
	}
	/**
	 * 获取：所属公司名称
	 */
	public Integer getHugongid() {
		return hugongid;
	}
	/**
	 * 设置：护工级别
	 */
	public void setLeve(String leve) {
		this.leve = leve;
	}
	/**
	 * 获取：护工级别
	 */
	public String getLeve() {
		return leve;
	}
	/**
	 * 设置：工作年龄
	 */
	public void setWorkage(String workage) {
		this.workage = workage;
	}
	/**
	 * 获取：工作年龄
	 */
	public String getWorkage() {
		return workage;
	}
	/**
	 * 设置：所属医院
	 */
	public void setHospitalid(Integer hospitalid) {
		this.hospitalid = hospitalid;
	}
	/**
	 * 获取：所属医院
	 */
	public Integer getHospitalid() {
		return hospitalid;
	}
	/**
	 * 设置：是否养老证
	 */
	public void setIsoldage(Integer isoldage) {
		this.isoldage = isoldage;
	}
	/**
	 * 获取：是否养老证
	 */
	public Integer getIsoldage() {
		return isoldage;
	}
	/**
	 * 设置：
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * 获取：
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * 设置：所属公司名称
	 */
	public void setCompanyname(Integer companyname) {
		this.companyname = companyname;
	}
	/**
	 * 获取：所属公司名称
	 */
	public Integer getCompanyname() {
		return companyname;
	}
	/**
	 * 设置：所属医院名称
	 */
	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}
	/**
	 * 获取：所属医院名称
	 */
	public String getHospitalname() {
		return hospitalname;
	}
	/**
	 * 设置：星级数
	 */
	public void setStars(Integer stars) {
		this.stars = stars;
	}
	/**
	 * 获取：星级数
	 */
	public Integer getStars() {
		return stars;
	}
	/**
	 * 设置：服务范围
	 */
	public void setServerange(String serverange) {
		this.serverange = serverange;
	}
	/**
	 * 获取：服务范围
	 */
	public String getServerange() {
		return serverange;
	}
	/**
	 * 设置：服务次数
	 */
	public void setServecounts(Integer servecounts) {
		this.servecounts = servecounts;
	}
	/**
	 * 获取：服务次数
	 */
	public Integer getServecounts() {
		return servecounts;
	}
	/**
	 * 设置：好评率
	 */
	public void setQuality(String quality) {
		this.quality = quality;
	}
	/**
	 * 获取：好评率
	 */
	public String getQuality() {
		return quality;
	}
	/**
	 * 设置：个人简介
	 */
	public void setIntroductions(String introductions) {
		this.introductions = introductions;
	}
	/**
	 * 获取：个人简介
	 */
	public String getIntroductions() {
		return introductions;
	}
	/**
	 * 设置：是否拥有健康证
	 */
	public void setIshealth(Integer ishealth) {
		this.ishealth = ishealth;
	}
	/**
	 * 获取：是否拥有健康证
	 */
	public Integer getIshealth() {
		return ishealth;
	}
	/**
	 * 设置：审核状态0 处于未提交审核 1提交审核 审核待处理 2审核通关 3审核拒绝
	 */
	public void setAuditstate(String auditstate) {
		this.auditstate = auditstate;
	}
	/**
	 * 获取：审核状态0 处于未提交审核 1提交审核 审核待处理 2审核通关 3审核拒绝
	 */
	public String getAuditstate() {
		return auditstate;
	}
	/**
	 * 设置：审核时间
	 */
	public void setAudittime(Date audittime) {
		this.audittime = audittime;
	}
	/**
	 * 获取：审核时间
	 */
	public Date getAudittime() {
		return audittime;
	}
	/**
	 * 设置：审核复述内容
	 */
	public void setAuditremark(String auditremark) {
		this.auditremark = auditremark;
	}
	/**
	 * 获取：审核复述内容
	 */
	public String getAuditremark() {
		return auditremark;
	}
	/**
	 * 设置：最后操作时间
	 */
	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}
	/**
	 * 获取：最后操作时间
	 */
	public Date getUptime() {
		return uptime;
	}
	/**
	 * 设置：身份证同步主表
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	/**
	 * 获取：身份证同步主表
	 */
	public String getIdcard() {
		return idcard;
	}
	public String getHealthimage() {
		return healthimage;
	}
	public void setHealthimage(String healthimage) {
		this.healthimage = healthimage;
	}
	public String getOldageimage() {
		return oldageimage;
	}
	public void setOldageimage(String oldageimage) {
		this.oldageimage = oldageimage;
	}
	
	
}
