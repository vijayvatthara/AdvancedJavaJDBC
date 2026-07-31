package com.vijay.advancedjava.jdbc.week03;

import com.vijay.advancedjava.connection.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CallableStatementDemo {

    public static void main(String[] args) {

        try (
                Connection connection = DatabaseConnection.getConnection()
        ) {

            CallableStatement callableStatement =
                    connection.prepareCall("{CALL UpdateSalary(?, ?)}");

            callableStatement.setInt(1, 103);
            callableStatement.setDouble(2, 75000);

            callableStatement.execute();

            System.out.println("Stored Procedure Executed Successfully.\n");

            Statement statement = connection.createStatement();

            ResultSet rs =
                    statement.executeQuery("SELECT * FROM employee");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | "
                                + rs.getString("name") + " | "
                                + rs.getDouble("salary")
                );

            }

            rs.close();
            statement.close();
            callableStatement.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}