package com.example.ltserver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ptst = null;
                 //获取登录页面提交的数据
        String loginEmail = request.getParameter("email");
        String loginPassword = request.getParameter("Password");
                 //sql语句
                 String selectEmail = "select email from students";
                 String selectPassword = "select Password from students where email = ?";

                 try {
                         //获取与数据库的链接
                         conn = new Jdbc().getConnection();
                         //遍历tb_user表，将数据库中所有username存入集合中
                         st = conn.createStatement();
                         rs = st.executeQuery(selectEmail);
                         List<String> usernameList = new ArrayList<String>();
                         while (rs.next()) {
                                 usernameList.add(rs.getString(1));
                             }
                         //关闭连接
                         if (rs != null) {
                                 rs.close();
                             }
                         if (st != null) {
                                 st.close();
                             }
                         //判断集合中是否存在所要登录的username
                         if (usernameList.contains(loginEmail)) {
                                 //查找username对应的password
                                 List<String> passwordList = new ArrayList<String>();
                                 ptst = (PreparedStatement) conn.prepareStatement(selectPassword);
                                 //设置ptst参数
                                 ptst.setString(1, loginEmail);
                                 rs = ptst.executeQuery();
                                 while (rs.next()) {
                                         passwordList.add(rs.getString(1));
                                     }
                                 //判断数据库与登录页面提交的password是否一致
                                 if (passwordList.get(0).equals(loginPassword)) {
                                         out.println("login successfully!");
                                     } else {
                                         out.println("wrong password!");
                                     }
                                 if (rs != null) {
                                         rs.close();
                                     }
                                 if (ptst != null) {
                                         ptst.close();
                                     }

                             } else {
                                 out.println("email not exist!");
                             }

                     } catch (ClassNotFoundException e) {
                         // TODO Auto-generated catch block
                         e.printStackTrace();
                     } catch (SQLException e) {
                         // TODO Auto-generated catch block
                         e.printStackTrace();
                     } finally {
                         //关闭链接
                         if (conn != null) {
                                 try {
                                         conn.close();
                                     } catch (SQLException e) {
                                         // TODO Auto-generated catch block
                                         e.printStackTrace();
                                     }
                             }
                     }
                 out.flush();
                 out.close();
        }
    }
