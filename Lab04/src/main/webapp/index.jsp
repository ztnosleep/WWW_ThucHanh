<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<h2>User Registration Form</h2>
<form action="${pageContext.request.contextPath}/users" method="post">
    Name: <input type="text" name="name"><br>
    Email: <input type="text" name="email"><br>
    Country: <input type="text" name="country"><br>
    <input type="submit" value="Register">
</form>
<c:if test="${not empty errors}">
    <ul>
        <c:forEach var="error" items="${errors}">
            <li>${error.message}</li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>