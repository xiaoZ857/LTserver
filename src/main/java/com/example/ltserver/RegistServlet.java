package com.example.ltserver;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistServlet", value = "/RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String username = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rpwd = request.getParameter("rpwd");
        String code = MD5Util.encode2hex(username+email+password);

        if(username==null||username.trim().isEmpty()){
            request.setAttribute("msg", "username can not be empty");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        if(password==null||password.trim().isEmpty()){
            request.setAttribute("msg", "password can not be empty");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        if(email==null||email.trim().isEmpty()){
            request.setAttribute("msg", "email can not be empty");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        if(!password.equals(rpwd)){
            request.setAttribute("msg", "two passwords are inconsistent");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        UserDao ud = new UserDao();
        User u = new User();
        MailUtils m = new MailUtils();
        u.setUsername(username);
        u.setEmail(email);
        u.setPassword(MD5Util.encode2hex(password));
        u.setState(0);
        u.setCode(code);
        boolean flag = ud.save(u);
        boolean act = ud.checkActive(email);
        if(flag&&(!act)){
            try {
                m.sendMail(email,"L&T project activate url", "http://localhost:8080/LTserver_war_exploded/ActiveServlet?code="+code+"");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            request.setAttribute("msg", "please activate your account in your email");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }else{
            request.setAttribute("msg", "the email is exist");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request,response);
    }
}

