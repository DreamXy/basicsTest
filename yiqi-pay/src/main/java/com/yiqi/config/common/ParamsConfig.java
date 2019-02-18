package com.yiqi.config.common;

/**
 * 参数定义类
 * @Author : Chan
 * @Description :
 * @Date : Created in 1:58 2018/9/7
 */
public class ParamsConfig {
    /**
     * 数据库类型
     */
    private static final String MYSQL = "mysql";
    private static final String MSSQL = "sqlserver";

    /**
     * 正则表达式
     */
    private static final String regex = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";

    /**
     * 短信发送次数
     */
//    public static final String SMS_SEND_NUM = "sms_send_num_";

    /**
     * 常用参数值
     */
    private static final Integer ZERO = 0;
    private static final Integer ONE = 1;
    private static final Integer TWO = 2;
    private static final Integer THREE = 3;
    private static final Integer FOUR = 4;
    private static final Integer FIVE = 5;
    private static final Integer SIX = 6;
    private static final Integer SEVEN = 7;
    private static final Integer EIGHT = 8;
    private static final Integer NINE = 9;
    private static final Integer TEN = 10;
    private static final Integer ELEVEN = 11;
    private static final Integer FIFTEEN = 15;
    private static final Integer TWENTYONE = 21;
    private static final Integer THIRTY = 30;

    private static final String ZERO_STR = "0";
    private static final String ONE_STR = "1";
    private static final String TWO_STR = "2";
    private static final String THREE_STR = "3";
    private static final String FOUR_STR = "4";


    /**
     * 字典名称定义
     */
    private static final String WAREHOUSETYPE = "仓库类型";
    private static final String CUSTOMWAREHOUSE = "定制仓选择";

    /**
     * 支付常量
     */
    private static final String SUBJECT = "怡亚通物流";
    private static final String RECHARGE = "余额充值";
    private static final String GETBACKORDER = "取回订单";
    private static final String DEPOSITORDER = "寄存订单";
    private static final String COMFIRMPACKING = "确认装箱";
    private static final String RENEWORDER = "续费订单";


    public static String getWAREHOUSETYPE() {
        return WAREHOUSETYPE;
    }

    public static String getCUSTOMWAREHOUSE() {
        return CUSTOMWAREHOUSE;
    }

    public static String getRegex() {
        return regex;
    }

    public static String getMYSQL() {
        return MYSQL;
    }

    public static String getMSSQL() {
        return MSSQL;
    }

    public static Integer getONE() {
        return ONE;
    }

    public static Integer getZERO() {
        return ZERO;
    }

    public static Integer getTEN() {
        return TEN;
    }

    public static Integer getTWO() {
        return TWO;
    }

    public static Integer getTHREE() {
        return THREE;
    }

    public static Integer getFOUR() {
        return FOUR;
    }

    public static Integer getFIVE() {
        return FIVE;
    }

    public static Integer getSIX() {
        return SIX;
    }

    public static Integer getSEVEN() {
        return SEVEN;
    }

    public static Integer getEIGHT() {
        return EIGHT;
    }

    public static Integer getNINE() {
        return NINE;
    }

    public static Integer getELEVEN() {
        return ELEVEN;
    }

    public static Integer getFIFTEEN() {
        return FIFTEEN;
    }

    public static Integer getTWENTYONE() {
        return TWENTYONE;
    }

    public static Integer getTHIRTY() {
        return THIRTY;
    }

    public static String getSUBJECT() {
        return SUBJECT;
    }

    public static String getRECHARGE() {
        return RECHARGE;
    }

    public static String getZeroStr() {
        return ZERO_STR;
    }

    public static String getOneStr() {
        return ONE_STR;
    }

    public static String getTwoStr() {
        return TWO_STR;
    }

    public static String getThreeStr() {
        return THREE_STR;
    }

    public static String getFourStr() {
        return FOUR_STR;
    }


    public static String getRENEWORDER() {
        return RENEWORDER;
    }

    public static String getDEPOSITORDER() {
        return DEPOSITORDER;
    }

    public static String getCOMFIRMPACKING() {
        return COMFIRMPACKING;
    }

    public static String getGETBACKORDER() {
        return GETBACKORDER;
    }
}
