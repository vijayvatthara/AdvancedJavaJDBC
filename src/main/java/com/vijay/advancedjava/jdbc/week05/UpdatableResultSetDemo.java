package com.vijay.advancedjava.jdbc.week05;

import com.vijay.advancedjava.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdatableResultSetDemo {

    public static void main(String[] args) {

        String sql = "SELECT emp_id, emp_name, salary FROM employee";

        try (
                Connection connection = DatabaseConnection.getConnection();

                Statement statement = connection.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE
                );

                ResultSet rs = statement.executeQuery(sql)
        ) {

            System.out.println("Original Employee Table:");

            // Display original table
            while (rs.next()) {

                System.out.println(
                        rs.getInt("emp_id")
                                + " - "
                                + rs.getString("emp_name")
                                + " - "
                                + rs.getDouble("salary")
                );
            }

            // 1. Update salary of employee 202
            rs.beforeFirst();

            while (rs.next()) {

                if (rs.getInt("emp_id") == 202) {

                    rs.updateDouble("salary", 58000);
                    rs.updateRow();

                    System.out.println(
                            "\nUpdated salary for emp_id 202."
                    );

                    break;
                }
            }

            // 2. Insert a new employee
            rs.moveToInsertRow();

            rs.updateInt("emp_id", 204);
            rs.updateString("emp_name", "Kiran");
            rs.updateDouble("salary", 62000);

            rs.insertRow();

            System.out.println(
                    "Inserted new employee (204, Kiran, 62000)."
            );

            // 3. Delete employee 201
            rs.beforeFirst();

            while (rs.next()) {

                if (rs.getInt("emp_id") == 201) {

                    rs.deleteRow();

                    System.out.println(
                            "Deleted employee with emp_id 201."
                    );

                    break;
                }
            }

            // 4. Display modified table
            System.out.println("\nModified Employee Table:");

            rs.beforeFirst();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("emp_id")
                                + " - "
                                + rs.getString("emp_name")
                                + " - "
                                + rs.getDouble("salary")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}