package com.example.ltserver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //转换字符串
        String username = request.getParameter("Name");
        String email = request.getParameter("email");
        String password = request.getParameter("Password");

        //调用UserDao、UserDaoImpl类及方法
        UserDao ud = new UserDaoImpl();

        //处理结果跳转相应页面
        boolean flag = ud.checkLogin(username,email, password);
        if(flag){
            //将提交的用户名存入session，前台登录成功页面调取
            HttpSession session = request.getSession();
            session.setAttribute("Name", username);

            //登录成功后跳转
            response.sendRedirect("loginSucceed.jsp");
        }else{
            response.sendRedirect("loginFailed.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
