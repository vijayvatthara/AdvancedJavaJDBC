package com.vijay.advancedjava.jdbc.week01;

import com.vijay.advancedjava.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentCRUDDemo {

    public static void main(String[] args) {

        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {

            // Drop table if already exists
            statement.executeUpdate("DROP TABLE IF EXISTS Student");

            // Create table
            statement.executeUpdate("""
                    CREATE TABLE Student(
                        RollNo INT PRIMARY KEY,
                        Name VARCHAR(50),
                        Address VARCHAR(100)
                    )
                    """);

            System.out.println("Student table created successfully.\n");

            // Insert records
            statement.executeUpdate("""
                    INSERT INTO Student VALUES
                    (1,'Vijay','Hyderabad'),
                    (2,'Rahul','Vizag'),
                    (3,'Anitha','Vijayawada')
                    """);

            System.out.println("Initial Records:");
            displayRecords(statement);

            // Insert more records
            statement.executeUpdate(
                    "INSERT INTO Student VALUES (4,'David','Bangalore')");

            statement.executeUpdate(
                    "INSERT INTO Student VALUES (5,'Eva','Chennai')");

            // Update
            statement.executeUpdate(
                    "UPDATE Student SET Address='Mumbai' WHERE RollNo=2");

            // Delete
            statement.executeUpdate(
                    "DELETE FROM Student WHERE RollNo=3");

            System.out.println("\nRecords After Insert, Update and Delete:");

            displayRecords(statement);

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    private static void displayRecords(Statement statement) throws Exception {

        ResultSet rs = statement.executeQuery("SELECT * FROM Student");

        while (rs.next()) {

            System.out.println(
                    rs.getInt("RollNo")
                            + " | "
                            + rs.getString("Name")
                            + " | "
                            + rs.getString("Address"));

        }

        rs.close();

    }

}