package com.teachmeskills.servlet;

import com.teachmeskills.listener.LoginListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    LoginListener loginListener;

    @Override
    public void init() throws ServletException {
        loginListener = new LoginListener();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        String role = (String) session.getAttribute("role");

        if (userName != null && role != null) {
            req.getRequestDispatcher("home.jsp").forward(req, resp);
            loginListener.log("User ->'" + userName + "' with role " + role + " accessed home page" + "' accessed home page from IP " + req.getRemoteAddr());
        }else {
            resp.sendRedirect("error/401.jsp");
        }

    }
}
