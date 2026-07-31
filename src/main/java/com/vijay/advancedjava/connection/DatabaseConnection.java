package com.vijay.advancedjava.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/advanced_java_lab";

    private static final String USER = "root";

    private static final String PASSWORD = "Vijay@9959287628";

    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {

            throw new RuntimeException("Database Connection Failed", e);

        }

    }

}