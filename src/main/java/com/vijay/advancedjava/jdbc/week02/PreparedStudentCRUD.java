package com.vijay.advancedjava.jdbc.week02;

import com.vijay.advancedjava.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PreparedStudentCRUD {

    public static void main(String[] args) {

        try (
                Connection con = DatabaseConnection.getConnection();
                Statement stmt = con.createStatement()
        ) {

            // Drop table if it exists
            stmt.executeUpdate("DROP TABLE IF EXISTS Student");

            // Create table
            stmt.executeUpdate("""
                    CREATE TABLE Student(
                        RollNo INT PRIMARY KEY,
                        Name VARCHAR(50),
                        Address VARCHAR(100)
                    )
                    """);

            // Insert using PreparedStatement
            PreparedStatement insertStmt =
                    con.prepareStatement(
                            "INSERT INTO Student VALUES (?, ?, ?)");

            insertStudent(insertStmt,1,"John","Hyderabad");
            insertStudent(insertStmt,2,"Alice","Vizag");
            insertStudent(insertStmt,3,"Bob","Vijayawada");

            System.out.println("Initial Records");

            displayRecords(con);

            // Insert more records
            insertStudent(insertStmt,4,"David","Bangalore");
            insertStudent(insertStmt,5,"Eva","Chennai");

            // Update
            PreparedStatement updateStmt =
                    con.prepareStatement(
                            "UPDATE Student SET Address=? WHERE RollNo=?");

            updateStmt.setString(1,"Mumbai");
            updateStmt.setInt(2,2);

            updateStmt.executeUpdate();

            // Delete

            PreparedStatement deleteStmt =
                    con.prepareStatement(
                            "DELETE FROM Student WHERE RollNo=?");

            deleteStmt.setInt(1,3);

            deleteStmt.executeUpdate();

            System.out.println("\nRecords After Insert Update Delete");

            displayRecords(con);

            insertStmt.close();
            updateStmt.close();
            deleteStmt.close();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static void insertStudent(
            PreparedStatement pstmt,
            int roll,
            String name,
            String address) throws Exception {

        pstmt.setInt(1,roll);
        pstmt.setString(2,name);
        pstmt.setString(3,address);

        pstmt.executeUpdate();

    }

    public static void displayRecords(Connection con) throws Exception {

        PreparedStatement pstmt =
                con.prepareStatement("SELECT * FROM Student");

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){

            System.out.println(
                    rs.getInt("RollNo")
                            + " | "
                            + rs.getString("Name")
                            + " | "
                            + rs.getString("Address")
            );

        }

        rs.close();
        pstmt.close();

    }

}