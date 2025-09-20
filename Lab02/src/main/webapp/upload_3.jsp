<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 9/20/2025
  Time: 11:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Upload to Database</title>
</head>
<body>
<form method="post" action="upload" enctype="multipart/form-data">
    <table border="0">
        <tr>
            <td>First Name: </td>
            <td><input type="text" name="firstName" size="50"/></td>
        </tr>
        <tr>
            <td>Last Name: </td>
            <td><input type="text" name="lastName" size="50"/></td>
        </tr>
        <tr>
            <td>Portrait Photo: </td>
            <td><input type="file" name="photo" size="50"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save">
            </td>
        </tr>
    </table>
</form>
</body>
</html>