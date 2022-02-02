package com.example.ltserver;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "register", value = "/register")
public class register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        String Name = request.getParameter("Name");
//        String email = request.getParameter("email");
//        String Password = request.getParameter("Password");
//        String rpsw = request.getParameter("confirm_password");//得到表单输入的内容
//        if(Name==null||Name.trim().isEmpty()){
//            request.setAttribute("msg", "Your name can not be empty!");
//            request.getRequestDispatcher("register.jsp").forward(request, response);
//            return;
//        }
//        if(Password==null|| Password.trim().isEmpty()){
//            request.setAttribute("msg", "Your password can not be empty!");
//            request.getRequestDispatcher("register.jsp").forward(request, response);
//            return;
//        }
//        if(email==null|| email.trim().isEmpty()){
//            request.setAttribute("msg", "Your email can not be empty!");
//            request.getRequestDispatcher("register.jsp").forward(request, response);
//            return;
//        }
//        if(!Password.equals(rpsw)){
//            request.setAttribute("msg", "The password is different!");
//            request.getRequestDispatcher("register.jsp").forward(request, response);
//            return;
//        }
//        Jdbc j = new Jdbc();
//        j.addStudent(Name,email,Password);
//        request.setAttribute("msg", "Welcome!"+Name+"to L&T Project!");
//        request.getRequestDispatcher("success.jsp").forward(request, response);

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

                 Statement st = null;
                 ResultSet rs  = null;

                 PreparedStatement ptst = null;
                 //创建用户名集合
                 List<String> usernameList = new ArrayList<String>();

                 //获取注册用户名
                 String registName = request.getParameter("Name");
                 //获取注册用户密码
                 String registPassword = request.getParameter("Password");
                 //获取注册用户二次密码
                 String registRepeatpsd = request.getParameter("confirm_password");
                 //email
                 String email = request.getParameter("email");


                 //获取与MySQL链接的Connection对象
                 Connection conn = null;
                 try {
                         conn = new Jdbc().getConnection();
                         /**
                           * 判断两次密码是否一致：
                           *         是：继续注册；
                           *         否：返回错误；
                           */
                         if (registPassword.equals(registRepeatpsd)) {
                                 try {
                                         /**
                                           * 判断用户表中是否已经存在该用户
                                           * 1.遍历tb_user表中所用的username字段
                                           * 2.将username字段中的所有数据存入集合中；
                                           * 3.判断集合中和否含有注册的用户名
                                           *         3.1：如果有，返回到error页面
                                           *         3.2：如果没有，进行注册操作
                                           */

                                         //遍历tb_user表中username字段
                                         String select = "select Name from students";
                                         st = conn.createStatement();
                                         rs = st.executeQuery(select);
                                         //将username字段的所有数据存入集合中

                                         while (rs.next()) {
                                                 usernameList.add(rs.getString(1));
                                             }
                                         //关闭ResultSet和Statement链接
                                         rs.close();
                                         st.close();

                                     } catch (SQLException e) {
                                         // TODO Auto-generated catch block
                                         e.printStackTrace();
                                     }

                                 if (usernameList.contains(registName)) {
                                         out.println("please use another name!");
                                     } else {
                                         String insert = "INSERT INTO students(Name,email,Password) values(?,?,?)";
                                         try {
                                                 ptst = conn.prepareStatement(insert);
                                                 //设置ptst参数
                                                 ptst.setString(1, registName);
                                                 ptst.setString(2,registPassword);
                                                 ptst.setString(3, email);

                                                 //执行sql语句
                                                 ptst.executeUpdate();
                                                 out.println("welcome!");
                                                 //关闭关闭ResultSet和Statement链接
                                                 ptst.close();

                                             } catch (SQLException e) {
                                                 // TODO Auto-generated catch block
                                                 e.printStackTrace();
                                             }

                                     }
                             } else {
                                 out.println("The password is not the same!");
                             }
                     } catch (ClassNotFoundException e1) {
                         // TODO Auto-generated catch block
                         e1.printStackTrace();
                     } catch (SQLException e) {
                     e.printStackTrace();
                 } finally {
                         try {
                                 //关闭Connection链接
                                 if (conn != null) {
                                         conn.close();
                                     }
                             } catch (SQLException e) {
                                 // TODO Auto-generated catch block
                                 e.printStackTrace();
                             }
                     }

                 out.flush();
                 out.close();
    }

}