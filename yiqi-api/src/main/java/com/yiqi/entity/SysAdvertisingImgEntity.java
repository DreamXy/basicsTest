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
@TableName("sys_advertising_img")
public class SysAdvertisingImgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String imgsrc;
	/**
	 * 
	 */
	private String imgurl;
	/**
	 * 
	 */
	private String imgtype;
	/**
	 * 
	 */
	private Integer imgsequence;
	/**
	 * 
	 */
	private Date createDate;

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
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	/**
	 * 获取：
	 */
	public String getImgsrc() {
		return imgsrc;
	}
	/**
	 * 设置：
	 */
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	/**
	 * 获取：
	 */
	public String getImgurl() {
		return imgurl;
	}
	/**
	 * 设置：
	 */
	public void setImgtype(String imgtype) {
		this.imgtype = imgtype;
	}
	/**
	 * 获取：
	 */
	public String getImgtype() {
		return imgtype;
	}
	/**
	 * 设置：
	 */
	public void setImgsequence(Integer imgsequence) {
		this.imgsequence = imgsequence;
	}
	/**
	 * 获取：
	 */
	public Integer getImgsequence() {
		return imgsequence;
	}
	/**
	 * 设置：
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：
	 */
	public Date getCreateDate() {
		return createDate;
	}
}
