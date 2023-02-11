package com.example.servlet;

import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public static final String SESSION_ATTRIBUTE_USER = "user";
    public static final String LOGIN_JSP = "/login.jsp";
    public static final String HELLO_JSP = "/user/hello.jsp";
    public static final String REQUEST_PARAMETER_LOGIN = "login";
    public static final String REQUEST_PARAMETER_PASSWORD = "password";
    private final Users user = Users.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        Object user = req.getSession().getAttribute(SESSION_ATTRIBUTE_USER);

        if (user == null) {
            resp.sendRedirect(LOGIN_JSP);
        } else {
            resp.sendRedirect(HELLO_JSP);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter(REQUEST_PARAMETER_LOGIN);
        String password = req.getParameter(REQUEST_PARAMETER_PASSWORD);
        boolean rightLogin = user.getUsers().contains(login);
        boolean rightPassword = password != null && !password.trim().isEmpty();

        if (rightLogin && rightPassword) {
            req.getSession().setAttribute(SESSION_ATTRIBUTE_USER, login);
            resp.sendRedirect(HELLO_JSP);
        } else {
            req.getRequestDispatcher(LOGIN_JSP).forward(req, resp);
        }
    }
}
