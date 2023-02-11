package com.example.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    public static final String SESSION_ATTRIBUTE_USER = "user";
    public static final String LOGIN_PAGE = "/login.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.getSession().removeAttribute(SESSION_ATTRIBUTE_USER);
        req.getSession().invalidate();
        resp.sendRedirect(LOGIN_PAGE);
    }
}
