package com.vijay.advancedjava.servlet.week07;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HeaderServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        PrintWriter out = response.getWriter();

        out.println(
                "<h2 style='color:blue;'>"
                        + "This is the included Header Section"
                        + "</h2>"
        );
    }
}