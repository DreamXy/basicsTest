package com.yiqi.databaseutil;

import lombok.Data;

@Data
public class TableInfo {

    private String sort;//序号
    private String tableName;//表名
    private String tableComment;//表注释
    private String columnName;//字段名
    private String columnComment;//字段注释
    private String isNullable;//是否可以为空
    private String columnType;//字段类型
    private String columnKey;//主键


}
