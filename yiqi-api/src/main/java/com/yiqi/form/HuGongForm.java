package com.yiqi.form;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "护工基本资料")
public class HuGongForm   {

	@ApiModelProperty(value = "护工ID")
	private String hgId;
	
	@ApiModelProperty(value = "姓名")
	private String name;

	@ApiModelProperty(value = "一寸头像")
	private MultipartFile photo;

	@ApiModelProperty(value = "年龄")
	private String age;

	@ApiModelProperty(value = "性别")
	private String sex;

	@ApiModelProperty(value = "身份证")
	private String idcard;

	@ApiModelProperty(value = "服务类型 1为 医院陪护 2为家庭陪护 3为母婴 4为管理员")
	private String servertype;

	@ApiModelProperty(value = "护工级别")
	private String leve;

	@ApiModelProperty(value = "护工级别名称")
	private String leveName;

	@ApiModelProperty(value = "工作年龄")
	private String workage;

	@ApiModelProperty(value = "所属医院编号")	
	private String hospitalid;

	@ApiModelProperty(value = "所属医院名称")
	private String hospitalname;

	@ApiModelProperty(value = "所属公司编号")
	private String companyid;

	@ApiModelProperty(value = "所属公司编号")
	private String companyname;

	@ApiModelProperty(value = "服务医院")
	private String serverange;

	@ApiModelProperty(value = "简介")
	private String introductions;

	@ApiModelProperty(value = "是否有养老护理证  0是没有 1是有")
	private String isoldage;

	@ApiModelProperty(value = "是否有健康证  0是没有 1是有")
	private String isHealth;

	@ApiModelProperty(value = "是否有母婴护理证 0是没有 1是有")
	private String isbaybecertificate;

	@ApiModelProperty(value = "是否为教师")
	private Integer ismanageteacher;

	@ApiModelProperty(value = "图片")
	public MultipartFile file36;
	

	public Integer getIsmanageteacher() {
		return ismanageteacher;
	}

	public void setIsmanageteacher(Integer ismanageteacher) {
		this.ismanageteacher = ismanageteacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getServertype() {
		return servertype;
	}

	public void setServertype(String servertype) {
		this.servertype = servertype;
	}

	public String getLeve() {
		return leve;
	}

	public void setLeve(String leve) {
		this.leve = leve;
	}

	public String getLeveName() {
		return leveName;
	}

	public void setLeveName(String leveName) {
		this.leveName = leveName;
	}

	public String getWorkage() {
		return workage;
	}

	public void setWorkage(String workage) {
		this.workage = workage;
	}

	public String getHospitalid() {
		return hospitalid;
	}

	public void setHospitalid(String hospitalid) {
		this.hospitalid = hospitalid;
	}

	public String getHospitalname() {
		return hospitalname;
	}

	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getServerange() {
		return serverange;
	}

	public void setServerange(String serverange) {
		this.serverange = serverange;
	}

	public String getIntroductions() {
		return introductions;
	}

	public void setIntroductions(String introductions) {
		this.introductions = introductions;
	}

	public String getIsoldage() {
		return isoldage;
	}

	public void setIsoldage(String isoldage) {
		this.isoldage = isoldage;
	}

	public String getIsHealth() {
		return isHealth;
	}

	public void setIsHealth(String isHealth) {
		this.isHealth = isHealth;
	}

	public String getIsbaybecertificate() {
		return isbaybecertificate;
	}

	public void setIsbaybecertificate(String isbaybecertificate) {
		this.isbaybecertificate = isbaybecertificate;
	}
	
	
	
}
