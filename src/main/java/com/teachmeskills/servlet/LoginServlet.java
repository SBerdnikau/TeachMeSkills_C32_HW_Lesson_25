package com.teachmeskills.servlet;

import com.teachmeskills.db.UsersDB;
import com.teachmeskills.listener.LoginListener;
import com.teachmeskills.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UsersDB usersDB;
    private LoginListener loginListener;

    @Override
    public void init() throws ServletException {
       usersDB = new UsersDB();
       loginListener = new LoginListener();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        String remoteIP = req.getRemoteAddr();

        if (userName == null || userName.isBlank() || userPassword == null || userPassword.isBlank()) {
            req.setAttribute("error", "Empty username or password");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }

        try {
            User user = usersDB.findUser(userName, userPassword);
            if (user != null){
                HttpSession session = req.getSession();
                session.setAttribute("userName", user.getName());
                session.setAttribute("role",user.getRole());
                req.getRequestDispatcher("/home.jsp").forward(req, resp);
                loginListener.logLoginAttempt(userName, true, remoteIP);
            }else {
                req.setAttribute("error", "Wrong password!");
                loginListener.logLoginAttempt(userName, false, remoteIP);
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("error", "This user not in datadase!");
            loginListener.logLoginAttempt(userName, false, remoteIP);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }


    }
}
