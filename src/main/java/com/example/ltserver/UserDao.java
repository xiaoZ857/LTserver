package com.example.ltserver;

import java.sql.*;

public class UserDao {
    public boolean save(User user) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement pst = null;
        String sql;
        try{

        /*
        创建连接Connection对象和Statement对象
        调用插入数据到数据库的方法
        */
        String name = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();
//        int state = user.getState();
//        String code = user.getCode();
//        Date time = user.getTime();
        conn = DBUtil.getConnection();
        //sql = "insert into students(name,email,password,state,code,time) values('"+name+"','"+email+"','"+password+"','"+state+"','"+code+"','"+time+"')";
        sql = "insert into students(name,email,password) values('"+name+"','"+email+"','"+password+"')";
        pst = conn.prepareStatement(sql);
        int row = pst.executeUpdate();
        if(row>0){
               flag = true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(pst, conn);
        }
        return flag;
    }

    public boolean checkLogin(String email, String password) {
        boolean flag = false;
        Connection conn;
        Statement st = null;
        ResultSet rs = null;
        /*
        创建Connection, Statement, ResultSet对象
        调用验证登录的方法
        */
        String sql ="select * from students where email = '"+ email +"'";
        conn = DBUtil.getConnection();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                if(rs.getString("password").equals(password)){
                    flag = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, st, conn);
        }
        return flag;
    }

}
