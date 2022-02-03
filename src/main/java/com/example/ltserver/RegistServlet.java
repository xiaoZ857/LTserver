package com.example.ltserver;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistServlet", value = "/RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String username = request.getParameter("Name");
        String email = request.getParameter("email");
        String password = request.getParameter("Password");

        //调用UserDao、UserDaoImpl类及方法
        UserDao ud = new UserDao();
        User u = new User();

        //添加用户提交的数据到数据库
        u.setUsername(username);
        u.setEmail(email);
        u.setPassword(password);

        //处理结果跳转相应页面
        boolean flag = ud.save(u);
        if(flag){
            //注册成功后跳转
            response.sendRedirect("login.jsp");
            System.out.println("register success");
        }else{
            response.sendRedirect("register.jsp");
            System.out.println("register fail");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
}
