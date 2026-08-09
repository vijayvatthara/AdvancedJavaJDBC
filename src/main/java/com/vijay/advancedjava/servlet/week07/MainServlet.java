package com.vijay.advancedjava.servlet.week07;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");

        out.println("<h1>Main Servlet Content Starts</h1>");

        // Include HeaderServlet
        RequestDispatcher rd =
                request.getRequestDispatcher("/header");

        rd.include(request, response);

        out.println("<h3>Back to Main Servlet Content</h3>");

        out.println("</body>");
        out.println("</html>");
    }
}