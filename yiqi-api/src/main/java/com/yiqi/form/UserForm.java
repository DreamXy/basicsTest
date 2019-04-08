package com.yiqi.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chan
 * @Description: 接收前端 用户参数类
 * @email chan150@163.com
 * @date 2019-01-23 10:47
 */
@Data
@ApiModel(value = "接收前端用户参数类")
public class UserForm implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户名", required = false)
	private String username;

	@ApiModelProperty(value = "手机号", required = false)
	private String mobile;

	@ApiModelProperty(value = "短信Code" , required = false)
	private String smscode;

	@ApiModelProperty(value = "注册类型" , required = false)
	private String regtype;

	@ApiModelProperty(value = "头像" , required = false)
	private String imagsrc;

	@ApiModelProperty(value = "微信app OpenId" , required = false)
	private String wxopenid;

	@ApiModelProperty(value = "QQ OpenId" , required = false)
	private String qqopenid;

	@ApiModelProperty(value = "小程序  OpenId" , required = false)
	private String xcopenid;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSmscode() {
		return smscode;
	}

	public void setSmscoded(String password) {
		this.smscode = password;
	}

	public String getRegtype() {
		return regtype;
	}

	public void setRegtype(String regtype) {
		this.regtype = regtype;
	}

	public String getImagsrc() {
		return imagsrc;
	}

	public void setImagsrc(String imagsrc) {
		this.imagsrc = imagsrc;
	}

	public String getWxopenid() {
		return wxopenid;
	}

	public void setWxopenid(String wxopenid) {
		this.wxopenid = wxopenid;
	}

	public String getQqopenid() {
		return qqopenid;
	}

	public void setQqopenid(String qqopenid) {
		this.qqopenid = qqopenid;
	}

	public String getXcopenid() {
		return xcopenid;
	}

	public void setXcopenid(String xcopenid) {
		this.xcopenid = xcopenid;
	}

	public void setSmscode(String smscode) {
		this.smscode = smscode;
	}
	
	

	
}
