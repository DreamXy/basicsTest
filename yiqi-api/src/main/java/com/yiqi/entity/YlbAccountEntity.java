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
 * @date 2019-02-16 17:00:46
 */
@TableName("ylb_account")
public class YlbAccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long accountid;
	/**
	 * 
	 */
	private String accountphone;
	/**
	 * 
	 */
	private String accountpwd;
	/**
	 * 
	 */
	private Date registertime;
	/**
	 * 
	 */
	private Date lastTime;
	/**
	 * 
	 */
	private Date uptime;
	/**
	 * 
	 */
	private Integer accountsate;
	/**
	 * 
	 */
	private Integer accouttype;
	/**
	 * 
	 */
	private String wxopenid;
	/**
	 * 
	 */
	private Integer registertype;
	/**
	 * 
	 */
	private String imagsrc;
	/**
	 * 
	 */
	private String wxname;
	/**
	 * 
	 */
	private String accoutnname;
	/**
	 * 
	 */
	private String ylbAccountcol;
	/**
	 * 
	 */
	private String hxopenid;

	/**
	 * 设置：
	 */
	public void setAccountid(Long accountid) {
		this.accountid = accountid;
	}
	/**
	 * 获取：
	 */
	public Long getAccountid() {
		return accountid;
	}
	/**
	 * 设置：
	 */
	public void setAccountphone(String accountphone) {
		this.accountphone = accountphone;
	}
	/**
	 * 获取：
	 */
	public String getAccountphone() {
		return accountphone;
	}
	/**
	 * 设置：
	 */
	public void setAccountpwd(String accountpwd) {
		this.accountpwd = accountpwd;
	}
	/**
	 * 获取：
	 */
	public String getAccountpwd() {
		return accountpwd;
	}
	/**
	 * 设置：
	 */
	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}
	/**
	 * 获取：
	 */
	public Date getRegistertime() {
		return registertime;
	}
	/**
	 * 设置：
	 */
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	/**
	 * 获取：
	 */
	public Date getLastTime() {
		return lastTime;
	}
	/**
	 * 设置：
	 */
	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}
	/**
	 * 获取：
	 */
	public Date getUptime() {
		return uptime;
	}
	/**
	 * 设置：
	 */
	public void setAccountsate(Integer accountsate) {
		this.accountsate = accountsate;
	}
	/**
	 * 获取：
	 */
	public Integer getAccountsate() {
		return accountsate;
	}
	/**
	 * 设置：
	 */
	public void setAccouttype(Integer accouttype) {
		this.accouttype = accouttype;
	}
	/**
	 * 获取：
	 */
	public Integer getAccouttype() {
		return accouttype;
	}
	/**
	 * 设置：
	 */
	public void setWxopenid(String wxopenid) {
		this.wxopenid = wxopenid;
	}
	/**
	 * 获取：
	 */
	public String getWxopenid() {
		return wxopenid;
	}
	/**
	 * 设置：
	 */
	public void setRegistertype(Integer registertype) {
		this.registertype = registertype;
	}
	/**
	 * 获取：
	 */
	public Integer getRegistertype() {
		return registertype;
	}
	/**
	 * 设置：
	 */
	public void setImagsrc(String imagsrc) {
		this.imagsrc = imagsrc;
	}
	/**
	 * 获取：
	 */
	public String getImagsrc() {
		return imagsrc;
	}
	/**
	 * 设置：
	 */
	public void setWxname(String wxname) {
		this.wxname = wxname;
	}
	/**
	 * 获取：
	 */
	public String getWxname() {
		return wxname;
	}
	/**
	 * 设置：
	 */
	public void setAccoutnname(String accoutnname) {
		this.accoutnname = accoutnname;
	}
	/**
	 * 获取：
	 */
	public String getAccoutnname() {
		return accoutnname;
	}
	/**
	 * 设置：
	 */
	public void setYlbAccountcol(String ylbAccountcol) {
		this.ylbAccountcol = ylbAccountcol;
	}
	/**
	 * 获取：
	 */
	public String getYlbAccountcol() {
		return ylbAccountcol;
	}
	/**
	 * 设置：
	 */
	public void setHxopenid(String hxopenid) {
		this.hxopenid = hxopenid;
	}
	/**
	 * 获取：
	 */
	public String getHxopenid() {
		return hxopenid;
	}
}
