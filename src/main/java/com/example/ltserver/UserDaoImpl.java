package com.example.ltserver;

import java.sql.*;


public class UserDaoImpl extends UserDao {
        public boolean save(User user){
        boolean flag = false;
        Connection conn = null;
        PreparedStatement pst = null;

        /*
        创建连接Connection对象和Statement对象
        调用插入数据到数据库的方法
        */
        conn = DBUtil.getConnection();
        String sql = "insert into students(Name,email,Password) values(?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            int row = pst.executeUpdate();
            if(row>0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(pst, conn);
        }
        return flag;
    }


    public boolean checkLogin(String email, String password){
        boolean flag = false;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        /*
        创建Connnection, Statement, ResultSet对象
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
