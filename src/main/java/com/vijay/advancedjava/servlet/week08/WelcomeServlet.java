package com.vijay.advancedjava.servlet.week08;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // 1. Read Cookie
        Cookie[] cookies = request.getCookies();
        String userFromCookie = null;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("username".equals(c.getName())) {
                    userFromCookie = c.getValue();
                }
            }
        }

        // 2. Read Session
        HttpSession session = request.getSession(false);

        String userFromSession =
                (session != null)
                        ? (String) session.getAttribute("user")
                        : null;

        // 3. Read URL parameter (rewriting)
        String userFromURL = request.getParameter("uname");

        out.println("<h2>Welcome User</h2>");
        out.println("<p>From Cookie: " + userFromCookie + "</p>");
        out.println("<p>From Session: " + userFromSession + "</p>");
        out.println("<p>From URL: " + userFromURL + "</p>");
    }
}