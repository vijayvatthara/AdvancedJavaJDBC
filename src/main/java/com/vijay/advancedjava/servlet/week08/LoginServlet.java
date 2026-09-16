package com.vijay.advancedjava.servlet.week08;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        // Simple authentication check
        if ("deepu".equals(user) && "divitha".equals(pass)) {

            // 1. Using Cookie
            Cookie ck = new Cookie("username", user);
            response.addCookie(ck);

            // 2. Using HttpSession
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // 3. Using URL Rewriting
            response.sendRedirect("WelcomeServlet?uname=" + user);

        } else {

            out.println("<h3>Invalid login. Try again.</h3>");

            RequestDispatcher rd =
                    request.getRequestDispatcher("login.html");

            rd.include(request, response);
        }
    }
}