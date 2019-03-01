package com.yiqi.entity;

import java.util.Date;

import javax.persistence.Column;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import com.baomidou.mybatisplus.enums.IdType;

/**
 * @author chan
 * @Description: 用户类
 * @email chan150@163.com
 * @date 2019-01-23 10:47
 */
@Data
@TableName("ylb_account")
@ApiModel(value = "用户类")
public class UserEntity  {

	/**
	 * 用户ID
	 */
	@TableId(value="AccountId")
	@ApiModelProperty(value = "ID")
	private int AccountId;
	
	
	@ApiModelProperty(value = "手机号码") 
	@TableId(value = "AccountPhone") 
	@Column(name="AccountPhone")
	private String AccountPhone;
	
	@ApiModelProperty(value = "注册时间")
	@TableId(value = "RegisterTime") 
	private Date RegisterTime;
	
	@ApiModelProperty(value = "最后登录时间")
	private Data Last_Time;
	
	@ApiModelProperty(value = "用户名")
	@TableId(value = "AccoutnName") 
	private String AccoutnName;
	
	@ApiModelProperty(value = "注册类型")
	@TableId(value = "RegisterType") 
	private int RegisterType;
	/**
	 * 密码
	 */
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String AccountPwd;

	
	
	public int getAccountId() {
		return AccountId;
	}



	public void setAccountId(int accountId) {
		AccountId = accountId;
	}



	public String getAccountPhone() {
		return AccountPhone;
	}



	public void setAccountPhone(String accountPhone) {
		AccountPhone = accountPhone;
	}



	public Date getRegisterTime() {
		return RegisterTime;
	}




	public void setRegisterTime(Date register_time) {
		this.RegisterTime = register_time;
	}



	public Data getLast_Time() {
		return Last_Time;
	}



	public void setLast_Time(Data last_Time) {
		Last_Time = last_Time;
	}



	public String getAccoutnName() {
		return AccoutnName;
	}



	public void setAccoutnName(String accoutnName) {
		AccoutnName = accoutnName;
	}



	public int getRegisterType() {
		return RegisterType;
	}



	public void setRegisterType(int registerType) {
		RegisterType = registerType;
	}



	public String getAccountPwd() {
		return AccountPwd;
	}



	public void setAccountPwd(String accountPwd) {
		AccountPwd = accountPwd;
	}



	@ApiModelProperty(value = "token值")
	@TableField(exist = false)
	private String token;



	public void setToken(String token2) {
		// TODO Auto-generated method stub
		token = token2;
	}

}
