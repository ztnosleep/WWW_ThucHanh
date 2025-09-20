<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 9/20/2025
  Time: 10:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload multi-files</title>
</head>
<body>
<h2>Upload multi-files</h2>
<form method="post" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
    File #1: <input type="file" name="file" /><br/>
    File #2: <input type="file" name="file" /><br/>
    File #3: <input type="file" name="file" /><br/>
    File #4: <input type="file" name="file" /><br/>
    File #5: <input type="file" name="file" /><br/><br/>
    <input type="submit" value="Upload" />
    <input type="reset" value="Reset" />
</form>
</body>
</html>
