/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.yiqi.utils;

import com.alibaba.fastjson.JSONObject;
import com.yiqi.common.utils.CodeMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author chan
 * @Description: 返回参数封装
 * @email chan150@163.com
 * @date 2018/12/2815:39
 */
@ApiModel(value = "返回参数封装类")
public class Result<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "返回消息")
	private String msg;
	@ApiModelProperty(value = "响应码")
	private int code;
	@ApiModelProperty(value = "返回类型")
	private T data;

	private Result(T data) {
		this.code = 0;
		this.msg = "成功";
		this.data = data;
	}
	private Result(CodeMsg cm) {
		if(cm == null){
			return;
		}
		this.code = cm.getCode();
		this.msg = cm.getMsg();
	}
	private Result(CodeMsg cm, T data) {
		if(cm == null){
			return;
		}
		this.code = cm.getCode();
		this.msg = cm.getMsg();
		this.data = data;
	}
	/**
	 * 成功时候的调用
	 * @return
	 */
	public static <T> Result<T> success(T data){
		if(null == data) {
			return Result.success();
		}
		return new Result<T>(data);
	}
	/**
	 * 成功，不需要传入参数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Result<T> success(){
		return (Result<T>) success(new JSONObject());
	}
	/**
	 * 失败时候的调用
	 * @return
	 */
	public static <T> Result<T> error(CodeMsg cm){
		return new Result<T>(cm);
	}
	/**
	 * 失败时候的调用，自定义返回值
	 * @return
	 */
	public static <T> Result<T> error(CodeMsg cm, T data){
		return new Result<T>(cm, data);
	}
	/**
	 * 失败时候的调用,扩展消息参数
	 * @param cm
	 * @param msg
	 * @return
	 */
	public static <T> Result<T> error(CodeMsg cm, String msg){
		cm.setMsg(msg);
		return new Result<T>(cm);
	}

	public T getData() {
		return data;
	}
	public String getMsg() {
		return msg;
	}
	public int getCode() {
		return code;
	}

}
