package com.yiqi.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * 注册表单
 *
 *
 * @since 3.1.0 2018-01-25
 */
@Data
@ApiModel(value = "注册表单")
public class RegisterForm {
    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "密码")
    private String smscode;

	@ApiModelProperty(value = "注册类型 1为手机 2为微信 3为QQ 4为小程序" )
	private String regtype;

	@ApiModelProperty(value = "看方法名" )
	private String openid;

	@ApiModelProperty(value = "头像" )
	private String imagsrc;
	
	@ApiModelProperty(value = "用户名")
	private String username;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

	public String getSmscode() {
		return smscode;
	}

	public void setSmscode(String smscode) {
		this.smscode = smscode;
	}

	public String getRegtype() {
		return regtype;
	}

	public void setRegtype(String regtype) {
		this.regtype = regtype;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getImagsrc() {
		return imagsrc;
	}

	public void setImagsrc(String imagsrc) {
		this.imagsrc = imagsrc;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    

}
