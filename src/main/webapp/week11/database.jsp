<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Database Access Through JSP</title>
</head>
<body>

<h2>Student Details</h2>

<%
    String url = "jdbc:mysql://localhost:3306/advanced_java_lab";
    String username = "root";
    String password = "Vijay@9959287628";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =
                DriverManager.getConnection(url, username, password);

        Statement stmt = con.createStatement();

        ResultSet rs =
                stmt.executeQuery("SELECT * FROM students");

        while (rs.next()) {
            out.println("ID: " + rs.getInt("id") + "<br>");
            out.println("Name: " + rs.getString("name") + "<br>");
            out.println("Course: " + rs.getString("course") + "<br>");
            out.println("<hr>");
        }

        rs.close();
        stmt.close();
        con.close();

    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>

</body>
</html>