package com.vijay.advancedjava.jdbc.week04;

import com.vijay.advancedjava.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableResultSetDemo {

    public static void main(String[] args) {

        String sql = "SELECT * FROM employee1 ORDER BY emp_id";

        try (
                Connection connection = DatabaseConnection.getConnection();

                Statement statement = connection.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                );

                ResultSet rs = statement.executeQuery(sql)
        ) {

            // Move to last row
            rs.last();

            System.out.println(
                    "Last Employee: "
                            + rs.getInt("emp_id")
                            + " - "
                            + rs.getString("emp_name")
            );

            // Move to first row
            rs.first();

            System.out.println(
                    "First Employee: "
                            + rs.getInt("emp_id")
                            + " - "
                            + rs.getString("emp_name")
            );

            // Move directly to third row
            if (rs.absolute(3)) {

                System.out.println(
                        "Third Employee: "
                                + rs.getInt("emp_id")
                                + " - "
                                + rs.getString("emp_name")
                );

            } else {

                System.out.println("Row 3 does not exist.");

            }

            // Move backwards
            System.out.println("\nTraversing backward from row 3:");

            while (rs.previous()) {

                System.out.println(
                        rs.getInt("emp_id")
                                + " - "
                                + rs.getString("emp_name")
                );
            }

            // Move cursor before first record
            rs.beforeFirst();

            // Move forward
            System.out.println("\nTraversing forward:");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("emp_id")
                                + " - "
                                + rs.getString("emp_name")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}