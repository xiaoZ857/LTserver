package com.example.ltserver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            String email = request.getParameter("email");
            String Password = request.getParameter("Password");
            String psw = new Jdbc().checklogin(email);
            if (psw == null) {
                request.setAttribute("msg", "No such student!");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;

            }
            if (psw != null && !psw.equals(Password)) {
                request.setAttribute("msg", "Wrong password!");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }
            if (psw.equals(Password)) {
                request.setAttribute("msg", "your email:" + email + ",welcome!");
                request.getRequestDispatcher("success.jsp").forward(request, response);
            }
        }
    }
