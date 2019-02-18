package com.yiqi.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author chan
 * @Description: 用户类
 * @email chan150@163.com
 * @date 2019-01-23 10:47
 */
@Data
@TableName("tb_user")
@ApiModel(value = "用户类")
public class UserEntity extends BasicEntity {

	/**
	 * 用户ID
	 */
	@TableId
	@ApiModelProperty(value = "ID")
	private Long userId;
	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名")
	private String username;
	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号")
	private String mobile;
	/**
	 * 密码
	 */
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	@ApiModelProperty(value = "token值")
	@TableField(exist = false)
	private String token;

}
