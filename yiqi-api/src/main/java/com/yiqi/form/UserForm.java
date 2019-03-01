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

	@ApiModelProperty(value = "用户名", required = true)
	private String username;

	@ApiModelProperty(value = "手机号", required = true)
	private String mobile;

	@ApiModelProperty(value = "密码" , required = true)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
