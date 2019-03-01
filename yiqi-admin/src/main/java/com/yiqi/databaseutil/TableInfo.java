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
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableComment() {
		return tableComment;
	}
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnComment() {
		return columnComment;
	}
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}
	public String getIsNullable() {
		return isNullable;
	}
	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}
	public String getColumnType() {
		return columnType;
	}
	 
	public void setColumnType(String columnType) {
		this.columnType = columnType; 
	}
	public String getColumnKey() {
		return columnKey;
	}
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

    

}
