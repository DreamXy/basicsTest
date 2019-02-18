
package com.yiqi.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;



/**
 * 用户Token
 * 
 * @author chenshun
 *
 * @date 2017-03-23 15:22:07
 */
@Data
@TableName("tb_token")
public class TokenEntity extends BasicEntity {

	/**
	 * 用户ID
	 */
	@TableId(type=IdType.INPUT)
	private Long userId;
	private String token;
	/**
	 * 过期时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date expireTime;

}
