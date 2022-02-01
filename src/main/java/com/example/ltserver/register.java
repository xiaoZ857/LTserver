package com.example.ltserver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "register", value = "/register")
public class register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String Name = request.getParameter("Name");
        String email = request.getParameter("email");
        String Password = request.getParameter("Password");
        String rpsw = request.getParameter("confirm_password");//得到表单输入的内容
        if(Name==null||Name.trim().isEmpty()){
            request.setAttribute("msg", "Your name can not be empty!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        if(Password==null|| Password.trim().isEmpty()){
            request.setAttribute("msg", "Your password can not be empty!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        if(!Password.equals(rpsw)){
            request.setAttribute("msg", "The password is different!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        Jdbc j = new Jdbc();
        j.addStudent(Name,email,Password);
        request.setAttribute("msg", "Welcome!"+Name+"to L&T Project!");
        request.getRequestDispatcher("success.jsp").forward(request, response);
    }

}