package com.yiqi.common.utils;

import java.io.Serializable;

/**
 * @author chan
 * @Description: 返回消息统一定义文件
 * @email chan150@163.com
 * @date 2018/12/2815:39
 */
public class CodeMsg implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;

    // 按照模块定义CodeMsg
    /** 通用异常 **/
    public static CodeMsg SUCCESS = new CodeMsg(0,"成功");
    public static CodeMsg ERROR = new CodeMsg(1,"失败");
    public static CodeMsg SERVER_EXCEPTION = new CodeMsg(500,"未知异常，请联系管理员");
    public static CodeMsg PARAMETER_ISNULL = new CodeMsg(501,"参数为空");
    /** 业务异常 **/
    public static CodeMsg NOT_FIND_DATA = new CodeMsg(300,"查找不到对应数据");

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
