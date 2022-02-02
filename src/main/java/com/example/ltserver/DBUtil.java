package com.example.ltserver;

import java.sql.*;

public class DBUtil {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/TEST?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String user="root";
    private static final String pwd="123456";


    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static void close(ResultSet rs, Statement st, Connection conn){
        try {
            if(rs != null){
                rs.close();
            }
            if(st != null){
                st.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement pst, Connection conn){
        close(null, pst, conn);
    }
}
