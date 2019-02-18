package com.yiqi.databaseutil;

import org.springframework.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateBaseToWord {
    /**
     *
     * @param dataBaseName 数据库名称
     * @param path 存储路径
     * @param fileName 存储名称
     * @return
     */
    public static String dateBaseToWord(String dataBaseName,String path,String fileName) {
        try {
            List<Map> tableList = DateBaseToWord.getAllTableList(dataBaseName);
            FtUtil ftUtil = new FtUtil();
            Map map = new HashMap<>();
            map.put("tableList", tableList);
//            ftUtil.generateFile("/", "word.xml", map, "D:/", "word.doc");
            fileName = fileName + ".doc";
            ftUtil.generateFile("/", "word.xml", map, path, fileName);
        }catch (Exception e){
            return "保存失败";
        }
        finally {
            System.exit(0);
        }
        return "生成成功保存路径为"+path;
    }

    public static List<Map> getAllTableList(String dataBaseName) {
        DbConn db = new DbConn();
        Connection con = db.getCon();

        List<TableInfo> tables = DateBaseToWord.getAllTable(con, dataBaseName);
        List<Map> listTabel = new ArrayList<>();
        for (TableInfo t : tables) {
            Map map = new HashMap();
            map.put("tableName", t.getTableName());
            map.put("tableComment", t.getTableComment());
            map.put("table", DateBaseToWord.getTableList(t.getTableName(), con, dataBaseName));
            listTabel.add(map);
        }
        db.closeConn();
        return listTabel;
    }

    private static List<TableInfo> getAllTable(Connection con, String dataBaseName) {
        List<TableInfo> list = new ArrayList<>();
        String sql = "select table_name, TABLE_COMMENT from information_schema.tables where table_schema='" + dataBaseName + "' and table_type='base table';";
        try {
            PreparedStatement pp = con.prepareStatement(sql);
            ResultSet rr = pp.executeQuery();
            while (rr.next()) {
                TableInfo table = new TableInfo();
                table.setTableName(formattUpperCase(rr.getString(1)));
                table.setTableComment(rr.getString(2));
                System.out.println(table.getTableComment() + "（" + table.getTableName() + "）：" + formattTableComment(table.getTableComment()));
                list.add(table);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }


    private static List<Map> getTableList(String tableName, Connection con, String dataBaseName) {
        List<Map> list = new ArrayList<>();
        String sql = "" +
                " select ORDINAL_POSITION sort, COLUMN_NAME columnName, COLUMN_COMMENT columnComment, " +
                " IS_NULLABLE isNullable, COLUMN_TYPE columnType, COLUMN_KEY columnKey from information_schema.columns\n " +
                " where table_schema = '" + dataBaseName + "' \n" +
                " and table_name = '" + tableName.toLowerCase() + "' ; ";
        try {
            PreparedStatement pp = con.prepareStatement(sql);
            ResultSet rr = pp.executeQuery();
            while (rr.next()) {
                Map map = new HashMap();
                map.put("sort", formattData(rr.getString(1)));
                map.put("columnName", formattUpperCase(rr.getString(2)));
                map.put("columnComment", formattData(rr.getString(3)));
                map.put("isNullable", formattData(rr.getString(4)));
                map.put("columnType", formattData(rr.getString(5)));
                map.put("columnKey", formattData(rr.getString(6)));
                list.add(map);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    private static String formattUpperCase(String column) {
        if (!StringUtils.isEmpty(column)) {
            return column.toUpperCase();
        }
        return column;
    }

    private static String formattTableComment(String tableComment) {
        if (tableComment.endsWith("表")) {
            return tableComment.substring(0, tableComment.length() - 1);
        }
        return tableComment;
    }

    public static String formattData(String val) {
        if (val.isEmpty()) {
            return "";
        }
        if (val.contains("\"")) {
            val.replaceAll("\"", "");

        }
        if (val.contains("'")) {
            val.replaceAll("'", "'");
        }
        if (val.contains("&")) {
            val.replaceAll("&", "&");
        }
        if (val.contains(">")) {
            val.replaceAll(">", ">");
        }
        if (val.contains("<")) {
            val.replaceAll("<", "<");
        }
        if (val.equals("PRI")) {
            val = "主键(PRI)";
        }
        if (val.equals("MUL")) {
            val = "";
        }
        return val;
    }


}
