<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("username") != null) {
        response.sendRedirect(request.getContextPath() + "/welcome.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<form action="${pageContext.request.contextPath}/login" method="post">
    <table>
        <tr><td>Username:</td><td><input type="text" name="username" size="50"/></td></tr>
        <tr><td>Password:</td><td><input type="password" name="password" size="50"/></td></tr>
        <tr><td colspan="2"><input type="submit" value="Login"/></td></tr>
    </table>
</form>

<% if ("invalid".equals(request.getParameter("error"))) { %>
<p style="color:red">Invalid username or password!</p>
<% } %>
</body>
</html>
