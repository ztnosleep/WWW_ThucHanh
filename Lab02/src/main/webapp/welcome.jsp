<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Welcome, <%= session.getAttribute("username") %>!</h2>
<a href="<%= request.getContextPath() %>/logout">Logout</a>
<a href="<%= request.getContextPath() %>/upload.jsp">Upload File</a>
<a href="<%= request.getContextPath() %>/upload_3.jsp">Upload File 3</a>
</body>
</html>
