<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 9/21/2025
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Shopping</title>
</head>
<body>
<h2>Product List</h2>
<c:forEach var="product" items="${products}">
    <div>
        <img src="${product.image}" alt="${product.name}" width="100">
        <p>${product.name} - $${product.price}</p>
        <a href="/products?action=add&id=${product.id}">Add to Cart</a>
    </div>
</c:forEach>

<h2>Cart</h2>
<c:if test="${empty cart}">
    <p>Cart is empty</p>
</c:if>
<c:if test="${not empty cart}">
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="item" items="${cart}">
            <tr>
                <td>${item.product.name}</td>
                <td>
                    <form action="/products?action=update&id=${item.product.id}" method="get">
                        <input type="number" name="quantity" value="${item.quantity}">
                        <input type="submit" value="Update">
                    </form>
                </td>
                <td>$${item.product.price}</td>
                <td>$${item.total}</td>
                <td><a href="/products?action=delete&id=${item.product.id}">Delete</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3">Total</td>
            <td>$${total}</td>
        </tr>
    </table>
</c:if>
</body>
</html>
