package com.yiqi.databaseutil;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class DbConn {
    //链接数据库
    public Connection getCon(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Yaml yaml = new Yaml();
            URL url = DbConn.class.getClassLoader().getResource("application-dev.yml");
            Map obj =yaml.load(new FileInputStream(url.getFile()));
            obj= (Map) obj.get("spring");
            obj= (Map) obj.get("datasource");
            obj= (Map) obj.get("druid");
            obj= (Map) obj.get("first");
            String urll=obj.get("url").toString();
            String user = obj.get("username").toString();
            String pwd =obj.get("password").toString();
            conn=DriverManager.getConnection(urll, user, pwd);

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //关闭数据库
    public void closeConn(){
        Connection con = getCon();
        try {
            if(!con.isClosed()){
                con.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        DbConn db = new DbConn();
        db.getCon();
        db.closeConn();
    }

}
