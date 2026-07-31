package com.vijay.advancedjava.connection;

import java.sql.Connection;

public class ConnectionTest {

    public static void main(String[] args) {

        try (Connection connection =
                     DatabaseConnection.getConnection()) {

            System.out.println("Connected Successfully!");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}