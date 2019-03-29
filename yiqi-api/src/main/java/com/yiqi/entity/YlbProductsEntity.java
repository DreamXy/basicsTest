package com.yiqi.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-26 00:29:42
 */
@TableName("ylb_products")
public class YlbProductsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer pid;
	/**
	 * 
	 */
	private Integer cateid;
	/**
	 * 
	 */
	private Integer storeid;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private BigDecimal shopprice;
	/**
	 * 
	 */
	private Integer state;
	/**
	 * 
	 */
	private Integer ishot;
	/**
	 * 
	 */
	private String showimg;
	/**
	 * 
	 */
	private Integer salecount;
	/**
	 * 
	 */
	private Integer visitcount;
	/**
	 * 
	 */
	private Integer reviewcount;
	/**
	 * 
	 */
	private Date addtime;
	/**
	 * 
	 */
	private BigDecimal costprice;
	/**
	 * 
	 */
	private BigDecimal marketprice;
	/**
	 * 
	 */
	private Integer displayorder;

	/**
	 * 设置：
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 设置：
	 */
	public void setCateid(Integer cateid) {
		this.cateid = cateid;
	}
	/**
	 * 获取：
	 */
	public Integer getCateid() {
		return cateid;
	}
	/**
	 * 设置：
	 */
	public void setStoreid(Integer storeid) {
		this.storeid = storeid;
	}
	/**
	 * 获取：
	 */
	public Integer getStoreid() {
		return storeid;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setShopprice(BigDecimal shopprice) {
		this.shopprice = shopprice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getShopprice() {
		return shopprice;
	}
	/**
	 * 设置：
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * 设置：
	 */
	public void setIshot(Integer ishot) {
		this.ishot = ishot;
	}
	/**
	 * 获取：
	 */
	public Integer getIshot() {
		return ishot;
	}
	/**
	 * 设置：
	 */
	public void setShowimg(String showimg) {
		this.showimg = showimg;
	}
	/**
	 * 获取：
	 */
	public String getShowimg() {
		return showimg;
	}
	/**
	 * 设置：
	 */
	public void setSalecount(Integer salecount) {
		this.salecount = salecount;
	}
	/**
	 * 获取：
	 */
	public Integer getSalecount() {
		return salecount;
	}
	/**
	 * 设置：
	 */
	public void setVisitcount(Integer visitcount) {
		this.visitcount = visitcount;
	}
	/**
	 * 获取：
	 */
	public Integer getVisitcount() {
		return visitcount;
	}
	/**
	 * 设置：
	 */
	public void setReviewcount(Integer reviewcount) {
		this.reviewcount = reviewcount;
	}
	/**
	 * 获取：
	 */
	public Integer getReviewcount() {
		return reviewcount;
	}
	/**
	 * 设置：
	 */
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	/**
	 * 获取：
	 */
	public Date getAddtime() {
		return addtime;
	}
	/**
	 * 设置：
	 */
	public void setCostprice(BigDecimal costprice) {
		this.costprice = costprice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getCostprice() {
		return costprice;
	}
	/**
	 * 设置：
	 */
	public void setMarketprice(BigDecimal marketprice) {
		this.marketprice = marketprice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getMarketprice() {
		return marketprice;
	}
	/**
	 * 设置：
	 */
	public void setDisplayorder(Integer displayorder) {
		this.displayorder = displayorder;
	}
	/**
	 * 获取：
	 */
	public Integer getDisplayorder() {
		return displayorder;
	}
}
