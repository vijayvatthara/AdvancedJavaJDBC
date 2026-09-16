<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Addition Result</title>
</head>
<body>

<h2>Addition Result</h2>

<%
    int num1 = Integer.parseInt(request.getParameter("num1"));
    int num2 = Integer.parseInt(request.getParameter("num2"));

    int sum = num1 + num2;
%>

<p>First Number: <%= num1 %></p>
<p>Second Number: <%= num2 %></p>
<p>Sum: <%= sum %></p>

</body>
</html>