package com.zhiye.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    static {
        try {

            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

     public static  Connection getConnection() throws SQLException{
       Connection conn  = null;
        try {
             conn  = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/zy_jxw?useUnicode=true&characterEncoding=utf8","root","root");
             System.out.println(" conn is ok !");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

//     public static void main(String[] args) {
//        DBConnect dbConnect = new  DBConnect();
//        try {
//            dbConnect.testCon();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }

}