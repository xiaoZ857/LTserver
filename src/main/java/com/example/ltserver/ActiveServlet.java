package com.example.ltserver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ActiveServlet", value = "/ActiveServlet")
public class ActiveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String code = request.getParameter("code");
            UserDao ud = new UserDao();
            boolean check = ud.checkUpdate(code);
            if(check){
                boolean re=ud.updateByCode(code);
                if(re){
                    request.setAttribute("msg", "activate successfully!");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            }else {
                request.setAttribute("msg", "activate fail!");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }

} catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
