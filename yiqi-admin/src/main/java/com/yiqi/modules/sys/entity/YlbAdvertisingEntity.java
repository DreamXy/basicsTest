package com.yiqi.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-25 20:51:30
 */
@TableName("ylb_advertising")
public class YlbAdvertisingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String turl;
	/**
	 * 
	 */
	private String tcontent;
	/**
	 * 
	 */
	private Date releasetime;

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
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：
	 */
	public void setTurl(String turl) {
		this.turl = turl;
	}
	/**
	 * 获取：
	 */
	public String getTurl() {
		return turl;
	}
	/**
	 * 设置：
	 */
	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}
	/**
	 * 获取：
	 */
	public String getTcontent() {
		return tcontent;
	}
	/**
	 * 设置：
	 */
	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
	}
	/**
	 * 获取：
	 */
	public Date getReleasetime() {
		return releasetime;
	}
}
